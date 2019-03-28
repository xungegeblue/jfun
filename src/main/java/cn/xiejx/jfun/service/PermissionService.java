package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.Permission;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/28
 */
public interface PermissionService {

    List<Permission> findByPid(long pid);

    Object getPermissionTree(List<Permission> byPid);
}
