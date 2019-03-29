package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.Permission;
import cn.xiejx.jfun.service.dto.PermissionDTO;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/28
 */
public interface PermissionService {

    List<Permission> findByPid(long pid);

    Object getPermissionTree(List<Permission> byPid);

    List<PermissionDTO> getPermissionData(List<Permission> byPid);

    Permission create(Permission resource);

    void update(Permission resource);

    void delete(Long id);

    List<Permission> queryAll(String name);

    Object buildTree(List<PermissionDTO> list);
}
