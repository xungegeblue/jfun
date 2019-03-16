package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.shiro.ShiroRealm;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.dto.AuthenticationInfo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.aop.AuthenticatedAnnotationHandler;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author 谢镜勋
 * @Date 2019/3/12
 */
@RestController
public class HomeController {
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    ShiroRealm shiroDbRealm;
    @RequestMapping(value = "info")
    public User info() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user;
    }

    @RequestMapping(value = "/login")
    public ResponseEntity login(@RequestBody User user) throws Exception {
        try {
            if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
                throw new AuthenticationException();
            }
            UsernamePasswordToken u = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(u);

            User a = (User) subject.getPrincipal();
            a.setRoles(Arrays.asList("ADMIN"));
            AuthenticationInfo info = new AuthenticationInfo();
            info.setToken((String) subject.getSession().getId());
            info.setUser(a);
            return ResponseEntity.ok(info);
        }  catch (Exception e) {
            throw new Exception("登录失败");
        }
    }

}
