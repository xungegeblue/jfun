package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.service.RedisService;
import cn.xiejx.jfun.vo.RedisVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 谢镜勋
 * @Date 2019/4/10
 */
@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

    @Log("查看Redis缓存")
    @GetMapping(value = "/redis")
    @RequiresPermissions(value = {"REDIS_VIEW", "REDIS_ALL"}, logical = Logical.OR)
    public ResponseEntity redis(String key, Pageable pageable) {
        return new ResponseEntity(redisService.findByKey(key,pageable), HttpStatus.OK);
    }

    @Log("新建Redis缓存")
    @PostMapping(value = "/redis")
    @RequiresPermissions(value = {"REDIS_ADD", "REDIS_ALL"}, logical = Logical.OR)
    public ResponseEntity create(@Validated @RequestBody RedisVo resources) {
        redisService.save(resources);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Log("修改Redis缓存")
    @PutMapping(value = "/redis")
    @RequiresPermissions(value = {"REDIS_EDIT", "REDIS_ALL"}, logical = Logical.OR)
    public ResponseEntity update(@Validated @RequestBody RedisVo resources) {
        redisService.save(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Redis缓存")
    @DeleteMapping(value = "/redis")
    @RequiresPermissions(value = {"REDIS_DEL", "REDIS_ALL"}, logical = Logical.OR)
    public ResponseEntity delete(@RequestBody RedisVo resources) {
        redisService.delete(resources.getKey());
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("删除全部Redis缓存")
    @DeleteMapping(value = "redis/all")
    @RequiresPermissions(value = {"REDIS_DEL", "REDIS_ALL"}, logical = Logical.OR)
    public ResponseEntity deleteAll() {
        redisService.flushdb();
        return new ResponseEntity(HttpStatus.OK);
    }
}
