package cn.xiejx.jfun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@TableName(value = "sys_permission")
public class Permission implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;//主键.

    @NotBlank
    private String name;//名称.

    private String alias;//中文名称
    private Long pid; //父编号

    @TableField(value = "create_time")
    private Timestamp createTime;

}
