package cn.xiejx.jfun.controller;

import cn.hutool.core.date.DateUtil;
import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.exection.EntityExistException;
import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.service.RoleService;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    @RequiresPermissions(value = {"user:list", "role:list"}, logical = Logical.OR)
    @GetMapping("/role/tree")
    public ResponseEntity tree() {
        Object roleTree = roleService.getRoleTree();
        return ResponseEntity.ok(roleTree);
    }


    @GetMapping("/role")
    public ResponseEntity list(Role role, Page page) {
        IPage<Role> iPage = roleService.selectRolePage(page, role);
        return ResponseEntity.ok(iPage);
    }

    @PutMapping("/role")
    public ResponseEntity edit(@RequestBody Role role) {
        if (role.getId() == null) {//简单的数据校验
            throw new EntityExistException(Role.class, "id", "角色ID不存在");
        }
        roleService.update(role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/role/{id}")
    public ResponseEntity getRole(@PathVariable Long id) {
        Role role = roleService.findRoleById(id);
        return new ResponseEntity(role, HttpStatus.OK);
    }

    //新增角色
    @PostMapping("/role")
    public ResponseEntity create(@RequestBody Role role) {
        if (!StringUtils.isEmpty(role.getId())) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        role.setCreateTime(DateUtil.date().toTimestamp());
        return new ResponseEntity(roleService.create(role), HttpStatus.CREATED);
    }

    @Log(descript = "更新角色权限")
    @PutMapping("/role/permission")
    public ResponseEntity permission(@RequestBody Role resources) {
        roleService.updatePermission(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log(descript = "更新角色菜单")
    @PutMapping("/role/menu")
    public ResponseEntity menu(@RequestBody Role resource) {
        roleService.updateMenu(resource);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
