package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.service.RoleService;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/25
 */
@Slf4j
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;
    private static final String ENTITY_NAME = "role";
    @RequiresPermissions(value = {"user:list","role:list"},logical = Logical.OR)
    @GetMapping("/role/tree")
    public ResponseEntity tree(){
        Object roleTree = roleService.getRoleTree();
        return ResponseEntity.ok(roleTree);
    }


    @GetMapping("/role")
    public ResponseEntity list(Role role, Page page){
        IPage<Role> iPage = roleService.selectRolePage(page,role);
        return ResponseEntity.ok(iPage);
    }

    //新增角色
    @PostMapping("/role")
    public ResponseEntity create(@RequestBody Role role){
        if(!StringUtils.isEmpty(role.getId())){
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(roleService.create(role), HttpStatus.CREATED);
    }
}
