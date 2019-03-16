package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.RoleMapper;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
