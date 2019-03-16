package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.MenuMapper;
import cn.xiejx.jfun.entity.Menu;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.service.MenuService;
import cn.xiejx.jfun.service.dto.MenuDTO;
import cn.xiejx.jfun.util.Trans2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
    public List<MenuDTO> getMenuByRole(List<Role> roles) {
        Set<Menu> menus = new LinkedHashSet<>();
        for (Role role : roles) {
            List<Menu> rs = mapper.getMenuByRole(role.getId());
            menus.addAll(rs);
        }
        List<MenuDTO> collect = menus.stream().map(Trans2Entity::toDto).collect(Collectors.toList());
        return collect;
    }




}
