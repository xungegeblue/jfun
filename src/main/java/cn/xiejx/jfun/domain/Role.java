package cn.xiejx.jfun.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {
    private String id;
    private String name;
    private Date createTime;
    private Date updateTime;
    private String status;//1启用 0禁用
    private List<Permission> permissions;
}
