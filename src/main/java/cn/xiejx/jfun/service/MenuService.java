package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.Menu;
import cn.xiejx.jfun.entity.Role;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
public interface MenuService {
    List<Menu> getMenuByRole(List<Role> roles);

    List<Menu> buildTree(List<Menu> menus);

    Object buildMenu(List<Menu> tree);
}
