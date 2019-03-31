package cn.xiejx.jfun;

import cn.xiejx.jfun.quartz.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JfunApplication {
    public static void main(String[] args) {
        SpringApplication.run(JfunApplication.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
