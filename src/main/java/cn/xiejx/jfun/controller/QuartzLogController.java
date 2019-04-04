package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.QuartzLog;
import cn.xiejx.jfun.service.QuartzLogService;

import cn.xiejx.jfun.vo.Page;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 谢镜勋
 * @Date 2019/4/1
 */
@RestController
public class QuartzLogController {

    @Autowired
    QuartzLogService quartzLogService;

    @Log(descript = "获取定时任务的执行日志")
    @RequiresPermissions(value = {"JOB_ALL", "JOB_VIEW", "JOB_EDIT"}, logical = Logical.OR)
    @GetMapping("/quartz/log")
    public ResponseEntity logs(QuartzLog quartzLog,Page page) {
        return ResponseEntity.ok(quartzLogService.queryAll(quartzLog,page));
    }
}
