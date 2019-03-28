package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    public List<Role> selectRolesByUser(@Param("userId") Long userId);

    List<Role> getRoleTree();


    IPage<Role> selectRolesPage(Page page, @Param(value = "role") Role role);

    @Select("select * from sys_role where name=#{name}")
    Role findByName(String name);

    @Delete("delete from sys_role_permission where role_id=#{rid}")
    void deleteRolePermissByRid(@Param("rid") Long rid);

    @Insert("insert into sys_role_permission values(#{pid},#{rid})")
    void addRolePermissionByRid(@Param("rid") Long rid, @Param("pid") Long pid);

    @Delete("DELETE FROM sys_roles_menus WHERE role_id=#{rid}")
    void deleteRoleMenuByRid(Long rid);

    @Insert("INSERT INTO sys_roles_menus VALUES(#{rid},#{mid})")
    void andRoleMenuByRid(@Param("rid") Long rid, @Param("mid") Long mid);



    //获取角色信息，包括用户的权限和菜单
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "id", property = "permissions", many = @Many(select = "cn.xiejx.jfun.dao.PermissionMapper.findByRoleId")),
            @Result(column = "id", property = "menus", many = @Many(select = "cn.xiejx.jfun.dao.MenuMapper.getMenuByRole"))
    })
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    Role findRoleById(@Param("id") Long id);
}
