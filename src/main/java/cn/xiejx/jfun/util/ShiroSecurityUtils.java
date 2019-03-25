package cn.xiejx.jfun.util;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;

import java.lang.reflect.InvocationTargetException;

public class ShiroSecurityUtils {
    public static User getPrincipal(){
        Object keys = SecurityUtils.getSubject().getPrincipal();
        User u = new User();
        try {
            BeanUtils.copyProperties(u,keys);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("身份信息获取失败!!");
        }
        return u;
    }

}
