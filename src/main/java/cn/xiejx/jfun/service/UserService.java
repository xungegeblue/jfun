package cn.xiejx.jfun.service;


import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.dto.UserDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

public interface UserService extends IService<User> {
    /**通过username查找用户信息;*/
     User findByName(String username);

    Set<String> findPermissionByUser(String username);

    Set<String> findRoleByUser(String username);

    public IPage<User> selectUserPage(Page<User> page,User user);

    User create(User user);

    void update(User user);

    void delete(Long id);
}