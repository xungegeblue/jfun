package cn.xiejx.jfun.quartz;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

@Slf4j
public class QuartzRunable implements Runnable {

    private Object target;
    private Method method;
    private String params;

    public QuartzRunable(String beanName,String methodName,String params) throws NoSuchMethodException {
        this.target = SpringContextHolder.getBean(beanName);
        this.params = params;
        if(StringUtils.isEmpty(params)){
            method = target.getClass().getDeclaredMethod(methodName);
        }else{
            method = target.getClass().getDeclaredMethod(methodName,String.class);
        }
    }
    @Override
    public void run() {
        try{
        ReflectionUtils.makeAccessible(this.method);
            if(StringUtils.isEmpty(params)){
                method.invoke(target);
            }else{
                method.invoke(target,params);
            }
        }catch (Exception e){
            log.error("定时任务:{},执行失败",target.getClass().getName());
        }

    }
}
