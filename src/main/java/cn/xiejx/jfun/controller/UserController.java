package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.UserService;
import cn.xiejx.jfun.service.dto.UserDTO;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity user(Page page, User u) {
        IPage<User> iPage = userService.selectUserPage(page, u);
        return ResponseEntity.ok(iPage);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity user(@Validated @RequestBody User user) { //post使用@RequestBody接受数据
        User u = userService.create(user);
        return new ResponseEntity(u, HttpStatus.CREATED);
    }
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ResponseEntity edit(@Validated @RequestBody User user){
        userService.update(user);
        return ResponseEntity.ok(null);
    }
}
