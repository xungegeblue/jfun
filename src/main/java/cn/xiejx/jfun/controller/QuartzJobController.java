package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.log.Log;
import cn.xiejx.jfun.entity.QuartzJob;
import cn.xiejx.jfun.service.QuartzJobService;
import cn.xiejx.jfun.vo.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class QuartzJobController {

    @Autowired
    QuartzJobService jobService;


    @Log(descript = "查询定时任务")
    @GetMapping("/jobs")
    @RequiresPermissions(value = {"JOB_VIEW", "JOB_ALL"}, logical = Logical.OR)
    public ResponseEntity getJobs(QuartzJob job, Page pae) {
        return ResponseEntity.ok(jobService.queryAll(job, pae));
    }

    @Log(descript = "创建定时任务")
    @PostMapping("/jobs")
    @RequiresPermissions(value = {"JOB_ALL", "JOB_ADD"}, logical = Logical.OR)
    public ResponseEntity create(@RequestBody QuartzJob job) {
        if (job.getId() != null) {
            throw new BadRequestException("创建的任务不可以有ID");
        }
        QuartzJob j = jobService.create(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(j);
    }

    @Log(descript = "修改定时任务")
    @PutMapping("/jobs")
    @RequiresPermissions(value = {"JOB_ALL", "JOB_EDIT"}, logical = Logical.OR)
    public ResponseEntity edit(QuartzJob job) {
        if (job.getId() == null) {
            throw new BadRequestException("编辑的任务ID不为空");
        }
        jobService.edit(job);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Log(descript = "修改定时任务状态(恢复或者执行)")
    @PutMapping("/jobs/{id}")
    @RequiresPermissions(value = {"JOB_ALL", "JOB_EDIT"}, logical = Logical.OR)
    public ResponseEntity status(@PathVariable Long id) {
        QuartzJob job = jobService.findById(id);
        job.setIsPause(!job.getIsPause());
        jobService.updateJobPauseStatus(job);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Log(descript = "运行定时任务")
    @GetMapping("/jobs/exec/{id}")
    @RequiresPermissions(value = {"JOB_ALL", "JOB_EDIT"}, logical = Logical.OR)
    public ResponseEntity run(@PathVariable Long id) {
        QuartzJob quartzJob = jobService.findById(id);
        jobService.exec(quartzJob);
        return ResponseEntity.ok().build();
    }

    @Log(descript = "删除定时任务")
    @DeleteMapping("/job/{id}")
    @RequiresPermissions(value = {"JOB_ALL", "JOB_DEL"}, logical = Logical.OR)
    public ResponseEntity delete(@PathVariable Long id) {
        jobService.deleteJob(jobService.findById(id));
        return ResponseEntity.ok().build();
    }
}
