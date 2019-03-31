package cn.xiejx.jfun.config.quartz;


import cn.xiejx.jfun.entity.QuartzJob;
import cn.xiejx.jfun.quartz.QuartzManage;
import cn.xiejx.jfun.service.QuartzJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class JobRunner implements ApplicationRunner {

    @Autowired
    private QuartzJobService quartzJobService;

    @Autowired
    private QuartzManage quartzManage;

    //项目启动的时候重新激活启动任务
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("============注入定时任务===========");
        List<QuartzJob> jobs = quartzJobService.findByIsPause(false);

        jobs.forEach(job -> {
            quartzManage.andJob(job);
        });
        System.out.println("============定时任务注入完成==========");
    }
}
