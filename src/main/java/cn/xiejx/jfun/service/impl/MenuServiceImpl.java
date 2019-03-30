package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.exection.EntityExistException;
import cn.xiejx.jfun.dao.MenuMapper;
import cn.xiejx.jfun.entity.Menu;
import cn.xiejx.jfun.entity.Permission;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.service.MenuService;
import cn.xiejx.jfun.service.dto.MenuDTO;
import cn.xiejx.jfun.util.Trans2Entity;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
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
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Object getMenuTree(List<Menu> menus) {
        List<Map<String, Object>> list = new LinkedList<>();
        menus.forEach(menu -> {
                    if (menu != null) {
                        List<Menu> menuList = baseMapper.findByPid(menu.getId());
                        Map<String, Object> map = new HashMap<>();
                        map.put("id", menu.getId());
                        map.put("label", menu.getName());
                        if (menuList != null && menuList.size() != 0) {
                            map.put("children", getMenuTree(menuList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<MenuDTO> queryAll(String name) {
        List<Menu> menus = baseMapper.selectList(Wrappers.<Menu>lambdaQuery().like(!StringUtils.isEmpty(name), Menu::getName, name).orderByAsc(Menu::getSort));
        return toDto(menus);
    }

    private List<MenuDTO> toDto(List<Menu> menus) {
        List<MenuDTO> menuDTOS = new ArrayList<>();
        menus.forEach(menu -> {
            MenuDTO menuDTO = new MenuDTO();
            BeanUtils.copyProperties(menu, menuDTO);
            menuDTOS.add(menuDTO);
        });
        return menuDTOS;
    }


    @Override
    public Object buildTree(List<MenuDTO> menuDTOS) {
        List<MenuDTO> trees = new ArrayList<MenuDTO>();

        for (MenuDTO menuDTO : menuDTOS) {

            if ("0".equals(menuDTO.getPid().toString())) {
                trees.add(menuDTO);
            }

            for (MenuDTO it : menuDTOS) {
                if (it.getPid().equals(menuDTO.getId())) {
                    if (menuDTO.getChildren() == null) {
                        menuDTO.setChildren(new ArrayList<MenuDTO>());
                    }
                    menuDTO.getChildren().add(it);
                }
            }
        }

        Integer totalElements = menuDTOS != null ? menuDTOS.size() : 0;
        Map map = new HashMap();
        map.put("records", trees.size() == 0 ? menuDTOS : trees);
        map.put("total", totalElements);
        return map;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    //落到service就是resource了
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(Menu resources) {
        Menu menu = baseMapper.selectById(resources.getId());
        if (menu == null) {
            throw new BadRequestException("该菜单不存在");
        }
        if (resources.getIFrame()) {
            if (!(resources.getPath().toLowerCase().startsWith("http://") || resources.getPath().toLowerCase().startsWith("https://"))) {
                throw new BadRequestException("外链必须要http://或者https://开头");
            }
        }
        Menu dbMenu = baseMapper.findByName(resources.getName());
        if (dbMenu != null && dbMenu.getId() != resources.getId()) {
            throw new EntityExistException(Menu.class, "name", resources.getName());
        }

        menu.setName(resources.getName());
        menu.setComponent(resources.getComponent());
        menu.setPath(resources.getPath());
        menu.setIcon(resources.getIcon());
        menu.setIFrame(resources.getIFrame());
        menu.setPid(resources.getPid());
        menu.setSort(resources.getSort());
        baseMapper.updateById(menu);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Menu create(Menu menu) {
        return baseMapper.insert(menu) > 0 ? menu : null;
    }

}
