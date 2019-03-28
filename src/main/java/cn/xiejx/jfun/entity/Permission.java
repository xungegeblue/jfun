package cn.xiejx.jfun.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class Permission implements Serializable {
    private Long id;//主键.
    private String name;//名称.
    private String alias;//中文名称
    private Long pid; //父编号

    @TableField(value = "create_time")
    private Timestamp createTime;

}
