package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.shiro.ShiroRealm;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.dto.AuthenticationInfo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
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

import java.util.Arrays;

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

    @RequestMapping(value = "info", produces = "application/json;charset=utf-8")
    public User info() {
        User user = new User();
        return user;
    }


    @RequestMapping("test")
    public User test() {
        User u = new User();
        u.setName("test");
        return u;
    }

    @RequestMapping(value = "visits", produces = "application/json;charset=utf-8")
    public String visits(){
        return "{\"newVisits\":7,\"newIp\":1,\"recentVisits\":15,\"recentIp\":3}";
    }

    @RequestMapping(value = "/visits/chartData", produces = "application/json;charset=utf-8")
    public String charData(){
        return "{\"weekDays\":[\"Fri\",\"Sat\",\"Mon\"],\"ipData\":[1,1,1],\"visitsData\":[4,4,7]}";
    }
    @RequestMapping(value = "/login")
    public ResponseEntity login(@RequestBody User user) throws BadRequestException {
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
        } catch (UnknownAccountException uae) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "未知用户!");
        } catch (IncorrectCredentialsException ice) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "密码不匹配!");
        } catch (LockedAccountException lae) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "用户冻结!");
        } catch (AuthenticationException ae) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "认证失败!");
        }
    }

}
