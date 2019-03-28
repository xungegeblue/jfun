package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.MenuMapper;
import cn.xiejx.jfun.entity.Menu;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.service.MenuService;
import cn.xiejx.jfun.service.dto.MenuDTO;
import cn.xiejx.jfun.util.Trans2Entity;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu>  implements MenuService {
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

    @Override
    public List<Menu> findByPid(long pid) {

        return baseMapper.findByPid(pid);
    }

    @Override
    public Object getMenuTree(List<Menu> menus) {
        List<Map<String,Object>> list = new LinkedList<>();
        menus.forEach(menu -> {
                    if (menu!=null){
                        List<Menu> menuList = baseMapper.findByPid(menu.getId());
                        Map<String,Object> map = new HashMap<>();
                        map.put("id",menu.getId());
                        map.put("label",menu.getName());
                        if(menuList!=null && menuList.size()!=0){
                            map.put("children",getMenuTree(menuList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }


}
