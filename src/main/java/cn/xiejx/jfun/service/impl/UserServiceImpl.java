package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.UserDao;
import cn.xiejx.jfun.domain.User;
import cn.xiejx.jfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    /**
     * 获取用户信息，登录成功以后需要调用
     * @param userName
     * @return
     */
    @Override
    public User getUser(String userName) {

        return null;
    }
}
