package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.GenConfig;
import cn.xiejx.jfun.service.GenConfigService;
import cn.xiejx.jfun.service.GeneratorService;
import cn.xiejx.jfun.service.vo.ColumnInfo;
import cn.xiejx.jfun.service.vo.TableInfo;
import cn.xiejx.jfun.vo.Page;

import com.baomidou.mybatisplus.core.metadata.IPage;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 谢镜勋
 * 代码生成的控制器
 * @Date 2019/4/1
 */
@RestController
public class GeneratorController {


    @Value("${generator.enabled}")
    private Boolean generatorEnabled;

    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private GenConfigService genConfigService;

    @RequiresPermissions(value = {"GENERATOR_CODE"})
    @Log("获取表格信息")
    @GetMapping(value = "/generator/tables")
    public ResponseEntity getTables(@RequestParam(required = false, defaultValue = "") String name, Page page) {
        IPage<TableInfo> tables = generatorService.getTables(name, page);
        return ResponseEntity.ok(tables);
    }

    @RequiresPermissions(value = {"GENERATOR_CODE"})
    @Log("获取表格列信息")
    @GetMapping(value = "/generator/columns")
    public ResponseEntity getColumns(@RequestParam String tableName) {
        List<ColumnInfo> columns = generatorService.getColumnInfo(tableName);
        Map<String,Object> data = new HashMap<>();
        data.put("records",columns);
        data.put("total",columns.size());
        return ResponseEntity.ok(data);
    }
    //不可以使用path和requestbody，可以使用requestParam和requestBody
    @RequiresPermissions(value = {"GENERATOR_CODE"})
    @Log("生成代码")
    @PostMapping(value = "/generator")
    public ResponseEntity generator(@RequestBody List<ColumnInfo> columnInfos, @RequestParam String tableName) {
        if (!generatorEnabled) {
            throw new BadRequestException("此环境不允许生成代码！");
        }
        GenConfig genConfig = genConfigService.findById(1L);
        if (genConfig == null) {
            throw new BadRequestException("生成器没有设置,请进行配置");
        }
        generatorService.generator(genConfig, tableName, columnInfos);
        return ResponseEntity.ok().build();
    }



}
