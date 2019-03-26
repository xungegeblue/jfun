package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from sys_user where name=#{name}")
    User selectUser(@Param("name") String name);

    @Select("select * from sys_user where email=#{email}")
    User selectEmail(@Param("email")String email);

    List<String> selectUserPermission(String name);

    List<String> selectUserRole(String name);

    IPage<User> selectUserPage(Page<User> page,@Param(value = "user") User user);

    @Delete("delete from sys_user_role where uid=#{uid}")
    void delUserRoleByUid(@Param("uid") Long uid);

    @Insert("insert into sys_user_role values(#{uid},#{rid})")//少写了)
    void addRoleByUid(@Param("uid")Long uid,@Param("rid") Long rid);
}