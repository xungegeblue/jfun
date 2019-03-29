package cn.xiejx.jfun.controller;

import cn.hutool.core.date.DateUtil;
import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.Permission;
import cn.xiejx.jfun.service.PermissionService;
import cn.xiejx.jfun.service.dto.PermissionDTO;
import cn.xiejx.jfun.vo.Page;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 谢镜勋
 * @Date 2019/3/28
 */
@RestController
public class PermissionController {
    //返回状态码的优化!!
    //https://blog.csdn.net/chenxiaochan/article/details/73716617

    @Autowired
    PermissionService permissionService;

    public static final String ENTITY_NAME = "Permission";

    @GetMapping("/permission/tree")
    public ResponseEntity tree() {
        return new ResponseEntity(permissionService.getPermissionTree(permissionService.findByPid(0)), HttpStatus.OK);
    }

    @RequiresPermissions(value = {"PERMISSION_VIEW", "PERMISSION_ALL"}, logical = Logical.OR)
    @Log(descript = "查询权限")
    @GetMapping("/permission")
    public ResponseEntity view(@RequestParam(defaultValue = "",required = false) String name, Page page) {
        List<PermissionDTO> list =  permissionService.getPermissionData(permissionService.queryAll(name));
        return new ResponseEntity(permissionService.buildTree(list), HttpStatus.OK);
    }

    @RequiresPermissions(value = {"PERMISSION_ADD", "PERMISSION_ALL"}, logical = Logical.OR)
    @Log(descript = "添加权限")
    @PostMapping("/permission")
    public ResponseEntity add(@RequestBody  Permission resource) {
        //做基本的校验，设置基础数据
        if (resource.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        resource.setCreateTime(DateUtil.date().toTimestamp());
        Permission p = permissionService.create(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);//创建以后返回对象，因为有一些值是我们需要做下处理的（初始化的）
    }

    @RequiresPermissions(value = {"PERMISSION_EDIT", "PERMISSION_ALL"}, logical = Logical.OR)
    @Log(descript = "编辑权限")
    @PutMapping("/permission")
    public ResponseEntity edit(@RequestBody Permission resource) {
        if (resource.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        permissionService.update(resource);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //通常修改成功返回NO_CONTENT
    }

    @RequiresPermissions(value = {"PERMISSION_DEL", "PERMISSION_ALL"}, logical = Logical.OR)
    @Log(descript = "删除权限")
    @DeleteMapping("/permission/{id}")
    public ResponseEntity del(@PathVariable("id") Long id) {
        permissionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
