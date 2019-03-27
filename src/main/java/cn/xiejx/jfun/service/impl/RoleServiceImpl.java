package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.config.exection.EntityExistException;
import cn.xiejx.jfun.dao.RoleMapper;
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


}
