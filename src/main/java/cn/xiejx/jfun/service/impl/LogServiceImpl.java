package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.LogMapper;
import cn.xiejx.jfun.dao.TestStudentMapper;
import cn.xiejx.jfun.entity.QuartzLog;
import cn.xiejx.jfun.entity.TestStudent;
import cn.xiejx.jfun.service.LogService;
import cn.xiejx.jfun.service.TestStudentService;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.xiejx.jfun.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author 谢镜勋
 * @Date 2019/4/9
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public void save(ProceedingJoinPoint joinPoint, Log log) {

    }


    @Override
    public Page selectLogPage(IPage<Log> page, Log log) {
        return (Page) logMapper.selectPage(page, Wrappers.<Log>lambdaQuery().or(
                wapper -> {
                    wapper.eq(!StringUtils.isEmpty(log.getUsername()), Log::getUsername, log.getUsername());
                    wapper.eq(Log::getLogType, log.getLogType());
                    return wapper;
                }
        ));
    }
}
