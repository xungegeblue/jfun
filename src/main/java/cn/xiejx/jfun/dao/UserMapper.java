package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectUser(@Param("userName") String userName);

    List<String> selectUserPermission(String userName);

    List<String> selectUserRole(String userName);
}