package cn.xiejx.jfun.entity;

import lombok.Data;

/**
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Data
public class Menu {
    private Long id;
    private String name;
    private Long sort;
    private String path;
    private String component;
    private String icon;
    /**
     * 上级菜单ID
     */
    private Long pid;
    /**
     * 是否为外链 true/false
     */
    private Boolean iFrame;
}
