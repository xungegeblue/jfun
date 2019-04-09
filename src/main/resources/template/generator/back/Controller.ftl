package cn.xiejx.jfun.controller;
import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.${className};
import cn.xiejx.jfun.service.${className}Service;
import cn.xiejx.jfun.service.dto.${className}DTO;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;


import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @Author ${author}
 * @Date ${date}
 */
@RestController
public class ${className}Controller {
    @Autowired
    ${className}Service ${classNameLower}Service;

    @Log("查询${className}")
    @GetMapping(value = "/${classNameLower}")
    public ResponseEntity ${classNameLower}(Page page, ${className}DTO ${classNameLower}DTO) {
        IPage<${className}> iPage = ${classNameLower}Service.select${className}Page(page, ${classNameLower}DTO);
        return ResponseEntity.ok(iPage);
    }

    @Log("创建${className}")
    @PostMapping(value = "/${classNameLower}")
    public ResponseEntity ${classNameLower}(@Validated @RequestBody ${className} ${classNameLower}) {
        ${className}DTO ${classNameLower}DTO = ${classNameLower}Service.create(${classNameLower});
        return new ResponseEntity(${classNameLower}DTO, HttpStatus.CREATED);
    }

    @Log("编辑${className}")
    @PutMapping(value = "/${classNameLower}")
    public ResponseEntity edit(@Validated @RequestBody ${className}DTO ${classNameLower}DTO) {
        ${classNameLower}Service.update(${classNameLower}DTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Log("删除${className}")
    @DeleteMapping(value = "/${classNameLower}/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ${classNameLower}Service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
