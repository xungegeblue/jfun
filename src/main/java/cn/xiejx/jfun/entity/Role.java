package cn.xiejx.jfun.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Role implements Serializable {
    private Integer id; // 编号
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
    private List<Permission> permissions;//角色 -- 权限关系：多对多关系;
    private List<User> userInfos;// 一个角色对应多个用户
}
