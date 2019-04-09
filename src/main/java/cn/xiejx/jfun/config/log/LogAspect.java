package cn.xiejx.jfun.config.log;

import cn.hutool.core.date.DateUtil;
import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.service.LogService;
import cn.xiejx.jfun.util.ThrowableUtil;
import cn.xiejx.jfun.entity.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 谢镜勋
 * @Date 2019/3/28
 */
@Component
@Aspect
public class LogAspect {

    @Autowired
    LogService logService;

    private long currentTime = 0L;
    //https://blog.csdn.net/u010096717/article/details/82221263
    @Pointcut("@annotation(cn.xiejx.jfun.config.log.Log)")
    public void logPointcut() {
        //配置切点，无方法体
    }

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        currentTime = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new BadRequestException(e.getMessage());
        }
        Log log = new Log("INFO",System.currentTimeMillis() - currentTime);
        log.setCreateTime(DateUtil.date().toTimestamp());
        logService.save(joinPoint, log);
        return result;
    }

    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

        Log log = new Log("ERROR",System.currentTimeMillis() - currentTime);
        log.setExceptionDetail(ThrowableUtil.getStackTrace(e));
        log.setCreateTime(DateUtil.date().toTimestamp());
        logService.save((ProceedingJoinPoint)joinPoint, log);
    }
}
