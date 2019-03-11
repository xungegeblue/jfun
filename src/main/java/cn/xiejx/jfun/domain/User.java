package cn.xiejx.jfun.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private String id;
    private String userName;
    private String passWord;
    private String nickName;
    private Date createTime;
    private Date updateTime;
    private char enable;//1启用 0禁用
    private List<Role> roles;

}
