package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/27
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    //查询角色的所有权限
    @Select("SELECT p.* from sys_role_permission up LEFT JOIN sys_permission p ON(up.permission_id = p.id) WHERE up.role_id = #{rid} ")
    List<Permission> findByRoleId(long rid);

    @Select("SELECT * FROM sys_permission WHERE pid=#{pid}")
    List<Permission> findByPid(@Param("pid") long pid);
}
