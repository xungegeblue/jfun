package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.MenuMapper;
import cn.xiejx.jfun.entity.Menu;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper mapper;

    @Override
    public List<Menu> getMenuByRole(List<Role> roles) {
        Set<Menu> menus = new LinkedHashSet<>();
        for (Role role : roles) {
            List<Menu> rs = mapper.getMenuByRole(role.getId());
            menus.addAll(rs);
        }
        return menus.stream().collect(Collectors.toList());
    }

    @Override
    public List<Menu> buildTree(List<Menu> menus) {
        return null;
    }

    @Override
    public Object buildMenu(List<Menu> tree) {
        return null;
    }
}
