package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectUser(@Param("userName") String userName);

    List<String> selectUserPermission(String userName);

    List<String> selectUserRole(String userName);

    IPage<User> selectUserPage(Page<User> page,@Param(value = "user") User user);
}