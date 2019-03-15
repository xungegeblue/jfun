package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.vo.ResponseEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 谢镜勋
 * @Date 2019/3/12
 */
@RestController
public class HomeController {
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/login")
    public ResponseEntity login(@RequestBody User user) {

        ResponseEntity resp = new ResponseEntity();
        try {
            if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
                throw new AuthenticationException();
            }
            UsernamePasswordToken u = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(u);
            resp.success().msg(subject.getSession().getId());
            logger.info("用户：" + user.getUsername() + " 登录成功");
        } catch (IncorrectCredentialsException e) {
            resp.status(400).msg("密码错误");
        } catch (LockedAccountException e) {
            resp.status(400).msg("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            resp.status(400).msg("该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
