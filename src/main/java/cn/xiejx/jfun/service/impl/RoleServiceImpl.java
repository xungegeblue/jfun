package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.config.exection.EntityExistException;
import cn.xiejx.jfun.dao.RoleMapper;
import cn.xiejx.jfun.entity.Permission;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.RoleService;
import cn.xiejx.jfun.service.dto.RoleDTO;
import cn.xiejx.jfun.service.dto.UserDTO;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Service(value = "roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    public List<Role> getRolesByUser(User user) {
        return baseMapper.selectRolesByUser(user.getId());
    }

    @Override
    public Object getRoleTree() {
        List<Role> roleList = baseMapper.getRoleTree();
        List<Map<String, Object>> list = new ArrayList<>();
        for (Role role : roleList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", role.getId());
            map.put("label", role.getRemark());
            list.add(map);
        }
        return list; //如果直接使用mapper方法，需要设置表命，和映射
    }

    @Override
    public IPage<Role> selectRolePage(Page page, Role role) {
        return baseMapper.selectRolesPage(page, role);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Role create(Role resurce) {
        if (baseMapper.findByName(resurce.getName()) != null) {
            throw new EntityExistException(Role.class, "name", resurce.getName());
        }
        if (baseMapper.insert(resurce) > 0) {
            //删除角色所有权限
            baseMapper.deleteRolePermissByRid(resurce.getId());
            if (resurce.getPermissions() != null) {
                List<Long> pids = resurce.getPermissions().stream().map(x -> x.getId()).collect(Collectors.toList());

                pids.forEach((pid) -> {
                    baseMapper.addRolePermissionByRid(resurce.getId(), pid);
                });
            }
        }
        return resurce;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updatePermission(Role resources) {
        if (baseMapper.selectById(resources.getId()) == null) {
            throw new EntityExistException(Role.class, "id", "没有对应的角色");
        }
        baseMapper.deleteRolePermissByRid(resources.getId());
        if (resources.getPermissions() != null) {
            List<Long> pids = resources.getPermissions().stream().map(x -> x.getId()).collect(Collectors.toList());
            pids.forEach((pid) -> {
                baseMapper.addRolePermissionByRid(resources.getId(), pid);
            });
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateMenu(Role resources) {
        if (baseMapper.selectById(resources.getId()) == null) {
            throw new EntityExistException(Role.class, "id", "没有对应的角色");
        }
        baseMapper.deleteRoleMenuByRid(resources.getId());
        if (resources.getMenus() != null) {
            List<Long> mids = resources.getMenus().stream().map(x -> x.getId()).collect(Collectors.toList());
            mids.forEach(id -> {
                baseMapper.andRoleMenuByRid(resources.getId(), id);
            });
        }
    }

    @Override
    public Role findRoleById(Long id) {
        return baseMapper.findRoleById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Role role) {
        //展示只可以修改角色名和角色描述
        //权限和菜单需要通过其他的接口进行修改
        Role dbRole = baseMapper.selectById(role.getId());
        dbRole.setName(role.getName());
        dbRole.setRemark(role.getRemark());
        baseMapper.updateById(dbRole);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteById(Long id) {
        return baseMapper.deleteById(id);
    }


}
