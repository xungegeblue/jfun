package cn.xiejx.jfun.service.dto;

import cn.xiejx.jfun.entity.User;
import lombok.Data;

/**
 * @Author 谢镜勋
 * @Date 2019/3/16
 */
@Data
public class AuthenticationInfo {
    String token;
    User user;
}
