package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.Menu;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.MenuService;
import cn.xiejx.jfun.service.RoleService;
import cn.xiejx.jfun.service.dto.MenuDTO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@RestController
@RequestMapping("api")
public class MenuController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    /**
     * 构建前端所需要的路由
     *
     * @return
     */
    @GetMapping(value = "/menus/build")
    public ResponseEntity buildMenus() {
        //查询用户关联的菜单
        User user = (User) SecurityUtils.getSubject();
//        List<MenuDTO> menuDTOList  = roleService.getRolesByUser(user);
//        List<MenuDTO> menus = menuService.getMenuByRole(menuDTOList);
//        List<MenuDTO> menuDTOTree = (List<MenuDTO>)menuService.buildTree(menuDTOList).get("content");
//        return new ResponseEntity(menuService.buildMenus(menuDTOTree),HttpStatus.OK);
        return null;
//        return new ResponseEntity(menuService.buildMenu(tree), HttpStatus.OK);
    }
}
