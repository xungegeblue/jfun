package cn.xiejx.jfun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.xiejx.jfun.dao")
public class JfunApplication {

    public static void main(String[] args) {
        SpringApplication.run(JfunApplication.class, args);
    }
}
