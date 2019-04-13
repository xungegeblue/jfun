package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.EmailConfig;
import cn.xiejx.jfun.service.EmailService;
import cn.xiejx.jfun.service.vo.EmailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 谢镜勋
 * @Date 2019/4/13
 */
@Slf4j
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/email")
    public ResponseEntity get(){
        return new ResponseEntity(emailService.find(), HttpStatus.OK);
    }

    @Log("配置邮件")
    @PutMapping(value = "/email")
    public ResponseEntity emailConfig(@Validated @RequestBody EmailConfig emailConfig){
        emailService.update(emailConfig,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("发送邮件")
    @PostMapping(value = "/email")
    public ResponseEntity send(@Validated @RequestBody EmailVo emailVo) throws Exception {
        log.warn("REST request to send Email : {}" +emailVo);
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }
}
