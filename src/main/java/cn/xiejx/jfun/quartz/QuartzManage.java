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

    public void addJob(QuartzJob job) {
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

            if (job.getIsPause()) {
                pauseJob(job);
            } else {
                log.info("添加任务成功,任务名称:{}", job.getJobName());
            }
        } catch (Exception e) {
            log.error("创建定时任务失败", e);
            throw new BadRequestException("创建定时任务失败");
        }
    }

    public void pauseJob(QuartzJob quartzJob) {
        try {
            JobKey jobKey = JobKey.jobKey(JOB_NAME + quartzJob.getId());
            scheduler.pauseJob(jobKey);
        } catch (Exception e) {
            log.error("定时任务暂停失败", e);
            throw new BadRequestException("定时任务暂停失败");
        }
    }

    /**
     * 恢复一个job
     *
     * @param quartzJob
     */
    public void resumeJob(QuartzJob quartzJob) {
        TriggerKey triggerKey = TriggerKey.triggerKey(JOB_NAME + quartzJob.getId());
        try {
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                addJob(quartzJob);
            }
            trigger.getJobDataMap().put(QuartzJob.JOB_KEY, quartzJob);

            JobKey jobKey = JobKey.jobKey(JOB_NAME + quartzJob.getId());
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error("恢复定时任务失败", e);
            throw new BadRequestException("恢复定时任务失败");
        }

    }

    /**
     * 更新job的cron表达式
     * 如果job不存在，那么创建一个
     * 这里需要特别注意同步的操作
     *
     * @param resource
     */
    public void updateJobCron(QuartzJob resource) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(JOB_NAME + resource.getId());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 如果不存在则创建一个定时任务
            if (trigger == null) {
                addJob(resource);
            }
            //重新设置触发器
            trigger = newTrigger()
                    .withIdentity(JOB_NAME + resource.getId())
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(resource.getCronExpression()))
                    .build();
            trigger.getJobDataMap().put(QuartzJob.JOB_KEY, resource);
            //重置启动时间
            ((CronTriggerImpl) trigger).setStartTime(new Date());

            //是否需要启动
            if (resource.getIsPause()) {
                pauseJob(resource);
            } else {
                scheduler.rescheduleJob(triggerKey, trigger);
            }

        } catch (Exception e) {
            log.error("更新定时任务失败", e);
            throw new BadRequestException("更新定时任务失败");
        }
    }

    public void runJobNow(QuartzJob quartzJob) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(JOB_NAME + quartzJob.getId());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 如果不存在则创建一个定时任务
            if (trigger == null) {
                addJob(quartzJob);
            }
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(QuartzJob.JOB_KEY, quartzJob);
            JobKey jobKey = JobKey.jobKey(JOB_NAME + quartzJob.getId());
            scheduler.triggerJob(jobKey, dataMap);
        } catch (Exception e) {
            log.error("定时任务执行失败", e);
            throw new BadRequestException("定时任务执行失败");
        }
    }

    public void deleteJob(QuartzJob quartzJob) {
        try {
            JobKey jobKey = JobKey.jobKey(JOB_NAME + quartzJob.getId());
            scheduler.deleteJob(jobKey);
        } catch (Exception e) {
            log.error("删除定时任务失败", e);
            throw new BadRequestException("删除定时任务失败");
        }
    }
}
