package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity user(@RequestParam String username, @RequestParam(defaultValue = "1", value = "page") long page) {
        Page pageData = new Page();
        pageData.setPages(page);
        pageData.setCurrent(page);
        User u = new User();
        u.setUsername(username);
        IPage<User> iPage = service.selectUserPage(pageData,u);
        return ResponseEntity.ok(iPage);
    }
}
