package cn.xiejx.jfun.service;


import cn.xiejx.jfun.entity.User;

import java.util.Set;

public interface UserService {
    /**通过username查找用户信息;*/
     User findByUserName(String username);

    Set<String> findPermissionByUser(String username);

    Set<String> findRoleByUser(String username);
}