package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
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
        User u = userService.findByUserName("admin");
        logger.info("jfun logback......"+u.toString());
        return "jfun success";
    }

}
