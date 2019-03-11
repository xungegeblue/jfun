package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User getUser(String userName);
}
