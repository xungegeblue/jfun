package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    public List<Role>  selectRolesByUser(@Param("userId") Integer userId);
}
