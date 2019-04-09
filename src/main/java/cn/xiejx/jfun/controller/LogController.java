package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.Log;
import cn.xiejx.jfun.service.LogService;
import cn.xiejx.jfun.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 谢镜勋
 * @Date 2019/4/9
 */
@RestController
public class LogController  {
    @Autowired
    LogService logService;

    @GetMapping(value = "/logs")
    public ResponseEntity allLog(Log log, Page page){
        log.setLogType("INFO");
        return ResponseEntity.ok(logService.selectLogPage(page,log));
    }

    @GetMapping(value = "/logs/error")
    public ResponseEntity errorLog(Log log, Page page){
        log.setLogType("ERROR");
        return ResponseEntity.ok(logService.selectLogPage(page,log));
    }
}
