package cn.xiejx.jfun.service.impl;


import cn.xiejx.jfun.dao.UserMapper;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        return userMapper.selectUser(userName);
    }


    @Override
    public Set<String> findPermissionByUser(String userName) {
        List<String> list = userMapper.selectUserPermission(userName);
        Set<String> set = new HashSet<>();
        if (list != null && list.size() > 0) {
            set.addAll(list);
        }
        return set;
    }

    @Override
    public Set<String> findRoleByUser(String userName) {
        List<String> list = userMapper.selectUserRole(userName);
        Set<String> set = new HashSet<>();
        if (list != null && list.size() > 0) {
            set.addAll(list);
        }
        return set;
    }

    @Override
    public IPage<User> selectUserPage(Page<User> page, User user) {
       return userMapper.selectUserPage(page,user);
    }
}