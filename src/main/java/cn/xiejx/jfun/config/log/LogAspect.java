package cn.xiejx.jfun.config.log;

import cn.xiejx.jfun.config.exection.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author 谢镜勋
 * @Date 2019/3/28
 */
@Component
@Slf4j
@Aspect
public class LogAspect {
    //https://blog.csdn.net/u010096717/article/details/82221263
    @Pointcut("@annotation(cn.xiejx.jfun.config.log.Log)")
    public void logPointcut() {
        //配置切点，无方法体
    }

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw new BadRequestException(throwable.getMessage() == null ? "请求失败" : throwable.getMessage());
        }
        return obj;
    }

    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        e.printStackTrace();
    }
}
