package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**测试类
 * @Author 谢镜勋
 * @Date 2019/3/11
 */
@RestController
public class HelloWorld {

    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @Autowired
    UserService userService;

    @GetMapping("/jfun")
    @ResponseBody
    public String jfun() {
        return "jfun 请求成功!!";
    }

    @RequiresRoles(value = {"admin"})
    @GetMapping("/shiro/role")
    public String testRole(){
       return "get it!!";
    }
    //如果用户没有登录直接请求这里，那么会跳转到login，进行登录
    @GetMapping("/user")
    public User user(){
        User u = (User) SecurityUtils.getSubject().getPrincipal();
        return u.simpleInfo();
    }
}
