package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.entity.User;


import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
public interface RoleService {
    public List<Role> getRolesByUser(User user);

    Object getRoleTree();
}
