package cn.xiejx.jfun.controller;

import cn.xiejx.jfun.entity.QuartzJob;
import cn.xiejx.jfun.service.QuartzJobService;
import cn.xiejx.jfun.vo.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class QuartzJobController {

    @Autowired
    QuartzJobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity getJobs(QuartzJob job, Page pae){
       return null;
    }

    @PostMapping("/jobs")
    public ResponseEntity create(QuartzJob job){
       QuartzJob j = jobService.create(job);
       return ResponseEntity.status(HttpStatus.CREATED).body(j);
    }
}
