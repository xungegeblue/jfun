package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 谢镜勋
 * @Date 2019/3/28
 */
@RestController
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping("/permission/tree")
    public ResponseEntity tree() {
        return new ResponseEntity(permissionService.getPermissionTree(permissionService.findByPid(0L)), HttpStatus.OK);
    }
}
