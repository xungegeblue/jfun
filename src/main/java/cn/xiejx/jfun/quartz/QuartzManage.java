package cn.xiejx.jfun.quartz;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.entity.QuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

import static org.quartz.TriggerBuilder.newTrigger;
@Slf4j
@Component
public class QuartzManage {

    private static final String JOB_NAME = "TASK_";

    @Resource(name = "scheduler")
    private Scheduler scheduler;

    public void andJob(QuartzJob job){
        try {
            // 构建job信息
            JobDetail jobDetail = JobBuilder.newJob(ExecutionJob.class).
                    withIdentity(JOB_NAME + job.getId()).build();

            Trigger trigger = newTrigger()
                    .withIdentity(JOB_NAME + job.getId())
                    .startNow()//需要设置开始执行
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression()))
                    .build();
            trigger.getJobDataMap().put(QuartzJob.JOB_KEY, job);

            //重新设置启动时间
            ((CronTriggerImpl) trigger).setStartTime(new Date());

            //开始调度
            scheduler.scheduleJob(jobDetail, trigger);

            if(job.getIsPause()){
                pauseJob(job);
            }else{
                log.info("添加任务成功,任务名称:{}",job.getJobName());
            }
        }catch (Exception e){
            log.error("创建定时任务失败",e);
            throw new BadRequestException("创建定时任务失败");
        }
    }

    public void pauseJob(QuartzJob quartzJob) {
        try {
            JobKey jobKey = JobKey.jobKey(JOB_NAME + quartzJob.getId());
            scheduler.pauseJob(jobKey);
        } catch (Exception e){
            log.error("定时任务暂停失败", e);
            throw new BadRequestException("定时任务暂停失败");
        }
    }
}
