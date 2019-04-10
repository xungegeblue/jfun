package cn.xiejx.jfun.service.impl;

import cn.hutool.json.JSONObject;
import cn.xiejx.jfun.dao.LogMapper;
import cn.xiejx.jfun.dao.TestStudentMapper;
import cn.xiejx.jfun.entity.QuartzLog;
import cn.xiejx.jfun.entity.TestStudent;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.LogService;
import cn.xiejx.jfun.service.TestStudentService;
import cn.xiejx.jfun.util.RequestHolder;
import cn.xiejx.jfun.util.ShiroSecurityUtils;
import cn.xiejx.jfun.util.WebUtil;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.xiejx.jfun.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author 谢镜勋
 * @Date 2019/4/9
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    @Autowired
    LogMapper logMapper;

    private final String LOGINPATH = "login";


    @Override
    public void save(ProceedingJoinPoint joinPoint, Log log) {
        //获取request
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        cn.xiejx.jfun.config.log.Log aopLog = method.getAnnotation(cn.xiejx.jfun.config.log.Log.class);

        if(log!=null){
            log.setDescription(aopLog.value());
        }
        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName()+"."+signature.getName()+"()";

        String params = "{";
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        // 用户名
        String username = "";

        if(argValues != null){
            for (int i = 0; i < argValues.length; i++) {
                params += " " + argNames[i] + ": " + argValues[i];
            }
        }
        // 获取IP地址
        log.setRequestIp(WebUtil.getIP(request));


        if(!LOGINPATH.equals(signature.getName())){
            User user = ShiroSecurityUtils.getPrincipal();
            username = user.getName();
        } else {
            try {
                JSONObject jsonObject = new JSONObject(argValues[0]);
                username = jsonObject.get("username").toString();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        log.setMethod(methodName);
        log.setUsername(username);
        log.setParams(params + " }");
        baseMapper.insert(log);

    }


    @Override
    public Page selectLogPage(IPage<Log> page, Log log) {
        return (Page) logMapper.selectPage(page, Wrappers.<Log>lambdaQuery().or(
                wapper -> {
                    wapper.eq(!StringUtils.isEmpty(log.getUsername()), Log::getUsername, log.getUsername());
                    wapper.eq(Log::getLogType, log.getLogType());
                    return wapper;
                }
        ).orderByDesc(Log::getCreateTime));
    }
}
