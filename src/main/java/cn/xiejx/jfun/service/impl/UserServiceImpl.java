package cn.xiejx.jfun.service.impl;


import cn.hutool.core.date.DateUtil;
import cn.xiejx.jfun.config.exection.EntityExistException;
import cn.xiejx.jfun.dao.UserMapper;
import cn.xiejx.jfun.entity.Role;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.UserService;
import cn.xiejx.jfun.service.dto.UserDTO;
import cn.xiejx.jfun.util.MD5Util;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String userName) {
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
        return userMapper.selectUserPage(page, user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User create(User user) {
        //创建新用户的使用判断用户名和邮箱是否已经使用过!
        if (baseMapper.selectUser(user.getName()) != null) {
            throw new EntityExistException(User.class, "username", user.getName());
        }
        if (baseMapper.selectEmail(user.getEmail()) != null) {
            throw new EntityExistException(User.class, "email", user.getEmail());
        }
        user.setAvatar("https://i.loli.net/2018/12/06/5c08894d8de21.jpg");
        user.setCreateTime(DateUtil.date().toTimestamp());
        user.setSalt(MD5Util.getRandomSalt());
        String enPass = MD5Util.encrypt("123456",user.getCredentialsSalt(),2);
        user.setPassword(enPass);
        if (userMapper.insert(user) > 0) { //插入以后没有uid导致报错
            List<Long> roleIds = user.getRoles().stream().map(Role::getId).collect(Collectors.toList());
            baseMapper.delUserRoleByUid(user.getUid());
            roleIds.forEach((rid) ->{
                baseMapper.addRoleByUid(user.getUid(),rid);
            });

        }
        return user;
    }
}