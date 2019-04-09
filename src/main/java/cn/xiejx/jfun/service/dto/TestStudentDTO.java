package cn.xiejx.jfun.service.dto;

import lombok.Data;



@Data
public class TestStudentDTO{
        /**
         * id
         */
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
