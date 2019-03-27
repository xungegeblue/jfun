package cn.xiejx.jfun.config.shiro;



import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;


import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;

import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.servlet.Filter;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration

public class ShiroConfig {
    //取redis连接配置
   @Value("${spring.redis.host}")
    private String host ;//= "localhost";
    @Value("${spring.redis.port}")
    private int port =  6379;
   @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.isRedisCache}")
    private int isRedisCache = 1;

    private static final String CACHE_KEY = "jfun:session:";

    private final static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);


    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/test", "anon");

        //authc:所有url必须通过认证才能访问，anon:所有url都可以匿名访问
        filterChainDefinitionMap.put("/**", "corsAuthenticationFilter");


        //自定义过滤器
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("corsAuthenticationFilter", corsAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
    public CORSAuthenticationFilter corsAuthenticationFilter(){
        return new CORSAuthenticationFilter();
    }
    //加密方式
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }


    //权限认证
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm ShiroRealm = new ShiroRealm();
        ShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return ShiroRealm;
    }


    @Bean
    public JedisPool jedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, 3000);
        return jedisPool;
    }



    @Bean
    public RedisManager redisManager(JedisPool jedisPool) {
        RedisManager redisManager = new RedisManager();
        redisManager.setJedisPool(jedisPool);
        logger.info("配置redis连接设置##########" + host + ":::" + port);
        return redisManager;
    }

    @Bean
    public RedisCacheManager cacheManager(RedisManager redisManager){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);
        return redisCacheManager;
    }

    @Bean
    SessionDAO sessionDAO(RedisManager redisManager) {

        if (1 == isRedisCache) {
            logger.info("启用Redis缓存");
            RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
            redisSessionDAO.setKeyPrefix(CACHE_KEY);
            redisSessionDAO.setRedisManager(redisManager);
            redisSessionDAO.setExpire(60*60*60);//超出这个时间不活动代表过期
            return redisSessionDAO;
        } else {
            MemorySessionDAO sessionDAO = new MemorySessionDAO();
            return sessionDAO;
        }
    }

    //自定义session管理
    @Bean
    public JfunSessionManager sessionManager(SessionDAO sessionDAO){
        JfunSessionManager jfunSessionManager = new JfunSessionManager();

        if (1 == isRedisCache) {
            jfunSessionManager.setSessionDAO(sessionDAO);
        } else {
            jfunSessionManager.setSessionDAO(new MemorySessionDAO());
        }

        return jfunSessionManager;
    }
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:config/ehcache.xml");
        return em;
    }

    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm,SessionDAO sessionDAO,EhCacheManager ehCacheManager,JfunSessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        securityManager.setSessionManager(sessionManager);
        securityManager.setCacheManager(ehCacheManager);
        return securityManager;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver
    createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException", "databaseError");//数据库异常处理
        mappings.setProperty("UnauthorizedException", "403");
        r.setExceptionMappings(mappings);
        r.setDefaultErrorView("error");
        r.setExceptionAttribute("ex");
        return r;
    }
}