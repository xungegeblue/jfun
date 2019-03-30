package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.Menu;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.MenuService;
import cn.xiejx.jfun.service.RoleService;
import cn.xiejx.jfun.service.dto.MenuDTO;
import cn.xiejx.jfun.util.ShiroSecurityUtils;
import cn.xiejx.jfun.util.Trans2Entity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@RestController
public class MenuController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    Trans2Entity trans2Entity;

    /**
     * 构建前端所需要的路由
     *
     * @return
     */
    @GetMapping(value = "/menus/build", produces = "application/json;charset=utf-8")
    public ResponseEntity buildMenus() {
        //查询用户关联的菜单
        User user = (User) ShiroSecurityUtils.getPrincipal();
        List<Role> menuDTOList = roleService.getRolesByUser(user);
        List<MenuDTO> menus = menuService.getMenuByRole(menuDTOList);
        List<MenuDTO> menuDTOTree = (List<MenuDTO>) trans2Entity.buildTree(menus).get("content");
        return new ResponseEntity(trans2Entity.buildMenus(menuDTOTree), HttpStatus.OK);
    }

    @GetMapping("/menus/tree")
    public ResponseEntity tree() {
        return new ResponseEntity(menuService.getMenuTree(menuService.findByPid(0L)), HttpStatus.OK);
    }

    @Log(descript = "查询菜单")
    @RequiresPermissions(value = {"MENU_VIEW", "MENU_ALL"}, logical = Logical.OR)
    @GetMapping("/menus")
    public ResponseEntity view(@RequestParam(defaultValue = "",required = false) String name) {
        List<MenuDTO> menus = menuService.queryAll(name);
        return ResponseEntity.status(HttpStatus.OK).body(menuService.buildTree(menus));
    }


    @Log(descript = "删除菜单")
    @RequiresPermissions(value = {"MENU_DEL", "MENU_ALL"}, logical = Logical.OR)
    @DeleteMapping("/menus/{id}")
    public ResponseEntity del(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Log(descript = "编辑菜单")
    @PutMapping("/menus")
    @RequiresPermissions(value = {"MENU_DEL", "MENU_ALL"}, logical = Logical.OR)
    public ResponseEntity edit(@RequestBody Menu menu) {
        menuService.edit(menu);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Log(descript = "添加菜单")
    @PostMapping("/menus")
    @RequiresPermissions(value = {"MENU_ADD", "MENU_ALL"}, logical = Logical.OR)
    public ResponseEntity add(@RequestBody @Validated Menu menu) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.create(menu));
    }
}
