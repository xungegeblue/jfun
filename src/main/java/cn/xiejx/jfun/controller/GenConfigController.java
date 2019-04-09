package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.GenConfig;
import cn.xiejx.jfun.service.GenConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenConfigController {

    @Autowired
    private GenConfigService genConfigService;

    @Log("获取生成器配置")
    @GetMapping(value = "/genConfig")
    @RequiresPermissions(value = {"GENERATOR_CODE"})
    public ResponseEntity getGenerator() {
        GenConfig genConfig = genConfigService.findById(1L);
        return ResponseEntity.ok(genConfig);
    }

    @Log("设置生成器配置")
    @PutMapping(value = "/genConfig")
    public ResponseEntity emailConfig(@Validated @RequestBody GenConfig genConfig){
        return new ResponseEntity(genConfigService.update(genConfig), HttpStatus.OK);
    }
}
