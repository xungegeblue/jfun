package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.dto.RoleDTO;
import cn.xiejx.jfun.service.dto.UserDTO;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;


import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
public interface RoleService {
    public List<Role> getRolesByUser(User user);

    Object getRoleTree();

    IPage<Role> selectRolePage(Page page, Role role);

    Role create(Role role);
}
