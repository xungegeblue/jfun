package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.RoleMapper;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper mapper;

    public List<Role> getRolesByUser(User user){
        return mapper.selectRolesByUser(user.getUid());
    }

    @Override
    public Object getRoleTree() {
        List<Role> roleList = mapper.getRoleTree();
        List<Map<String, Object>> list = new ArrayList<>();
        for (Role role : roleList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id",role.getId());
            map.put("label",role.getRemark());
            list.add(map);
        }
        return list; //如果直接使用mapper方法，需要设置表命，和映射
    }


}
