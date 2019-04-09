package cn.xiejx.jfun.controller;
import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.TestStudent;
import cn.xiejx.jfun.service.TestStudentService;
import cn.xiejx.jfun.service.dto.TestStudentDTO;
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
 * @Author miv
 * @Date 2019-04-09 13:48:50
 */
@RestController
public class TestStudentController {
    @Autowired
    TestStudentService testStudentService;

    @Log("查询TestStudent")
    @GetMapping(value = "/testStudent")
    public ResponseEntity testStudent(Page page, TestStudentDTO testStudentDTO) {
        IPage<TestStudent> iPage = testStudentService.selectTestStudentPage(page, testStudentDTO);
        return ResponseEntity.ok(iPage);
    }

    @Log("创建TestStudent")
    @PostMapping(value = "/testStudent")
    public ResponseEntity testStudent(@Validated @RequestBody TestStudent testStudent) {
        TestStudentDTO testStudentDTO = testStudentService.create(testStudent);
        return new ResponseEntity(testStudentDTO, HttpStatus.CREATED);
    }

    @Log("编辑TestStudent")
    @PutMapping(value = "/testStudent")
    public ResponseEntity edit(@Validated @RequestBody TestStudentDTO testStudentDTO) {
        testStudentService.update(testStudentDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Log("删除TestStudent")
    @DeleteMapping(value = "/testStudent/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        testStudentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
