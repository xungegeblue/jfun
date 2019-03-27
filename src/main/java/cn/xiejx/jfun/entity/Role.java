package cn.xiejx.jfun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@TableName("sys_role")
public class Role implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 编号
    private String name; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String remark; // 角色描述,UI界面显示使用
    private Boolean available; // 是否可用,如果不可用将不会添加给用户

    @TableField(exist = false)
    private Set<Permission> permissions;

    @TableField(exist = false)
    private Set<Menu> menus;
}
