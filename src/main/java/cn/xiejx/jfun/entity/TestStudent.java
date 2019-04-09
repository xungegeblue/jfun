package cn.xiejx.jfun.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;



@Data
@TableName(value = "test_student")
public class TestStudent{
        /**
         * id
         */
        @TableId(type = IdType.AUTO)
         private Integer id;
        /**
         * 姓名
         */
         private String name;
        /**
         * 年龄
         */
         private Integer age;
        /**
         * 信息
         */
         private String message;
}
