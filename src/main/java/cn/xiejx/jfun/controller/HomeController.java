package cn.xiejx.jfun.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author 谢镜勋
 * @Date 2019/3/12
 */
@RestController
public class HomeController {
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        ResponseEntity resp = new ResponseEntity();
        try {
            if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
                throw new AuthenticationException();
            }
            UsernamePasswordToken u = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(u);
            resp.success().msg(subject.getSession().getId());
            logger.info("用户：" + username + " 登录成功");
        } catch (IncorrectCredentialsException e) {
            resp.code(500).msg("密码错误");
        } catch (LockedAccountException e) {
            resp.code(500).msg("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            resp.code(500).msg("该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
