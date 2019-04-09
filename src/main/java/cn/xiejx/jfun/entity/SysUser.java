package cn.xiejx.jfun.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import java.sql.Timestamp;



@Data
@TableName(value = "sys_user")
public class SysUser{
        @TableId(type = IdType.AUTO)
         private Integer id;
         private String name;
         private String password;
         private String salt;
         private Integer state;
         private String email;
         private String avatar;
         private Timestamp createtime;
}
