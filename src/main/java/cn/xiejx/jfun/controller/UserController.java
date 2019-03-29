package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.UserService;
import cn.xiejx.jfun.service.dto.UserDTO;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import lombok.extern.java.Log;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequiresPermissions(value = {"USER_VIEW", "USER_ALL"}, logical = Logical.OR)
    @GetMapping(value = "/user")
    public ResponseEntity user(Page page, User u) {
        IPage<User> iPage = userService.selectUserPage(page, u);
        return ResponseEntity.ok(iPage);
    }

    @RequiresPermissions(value = {"USER_ADD", "USER_ALL"}, logical = Logical.OR)
    @PostMapping(value = "/user")
    public ResponseEntity user(@Validated @RequestBody User user) { //post使用@RequestBody接受数据
        User u = userService.create(user);
        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @RequiresPermissions(value = {"USER_EDIT", "USER_ALL"}, logical = Logical.OR)
    @PutMapping(value = "/user")
    public ResponseEntity edit(@Validated @RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(null);
    }


    @DeleteMapping(value = "/users/{id}")
    @RequiresPermissions(value = {"USER_DEL", "USER_ALL"}, logical = Logical.OR)
    public ResponseEntity delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
