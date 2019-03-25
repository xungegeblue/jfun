package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.service.RoleService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 谢镜勋
 * @Date 2019/3/25
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequiresPermissions(value = {"user:list","role:list"},logical = Logical.OR)
    @GetMapping("tree")
    public ResponseEntity tree(){
        Object roleTree = roleService.getRoleTree();
        return ResponseEntity.ok(roleTree);
    }
}
