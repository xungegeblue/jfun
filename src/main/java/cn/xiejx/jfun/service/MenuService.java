package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.Menu;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.service.dto.MenuDTO;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
public interface MenuService {
    List<MenuDTO> getMenuByRole(List<Role> roles);


    List<Menu> findByPid(long pid);

    Object getMenuTree(List<Menu> byPid);
}
