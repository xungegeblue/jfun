package cn.xiejx.jfun.quartz;

import cn.hutool.core.date.DateUtil;
import cn.xiejx.jfun.entity.QuartzJob;
import cn.xiejx.jfun.entity.QuartzLog;
import cn.xiejx.jfun.service.QuartzJobService;
import cn.xiejx.jfun.service.QuartzLogService;
import cn.xiejx.jfun.util.ThrowableUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Async
public class ExecutionJob extends QuartzJobBean {

    @Autowired
    private ExecutorService executorService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuartzManage manage;

    @Autowired
    private QuartzJobService quartzJobService;

    @Autowired
    private QuartzLogService quartzLogService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        QuartzJob quartzJob = (QuartzJob) jobExecutionContext.getMergedJobDataMap().get(QuartzJob.JOB_KEY);

        QuartzLog log = new QuartzLog();
        Long startTime = System.currentTimeMillis();
        try {
            log.setJobName(quartzJob.getJobName());
            log.setBeanName(quartzJob.getBeanName());
            log.setCronExpression(quartzJob.getCronExpression());
            log.setMethodName(quartzJob.getMethodName());
            log.setParams(quartzJob.getParams());

            logger.info("任务准备执行,任务名称{}", quartzJob.getBeanName());


            QuartzRunable task = new QuartzRunable(quartzJob.getBeanName(), quartzJob.getMethodName(), quartzJob.getParams());
            Future<?> future = executorService.submit(task);
            future.get();
            log.setIsSuccess(true);
            Long times = System.currentTimeMillis() - startTime;
            log.setTime(times);
            logger.info("任务执行完毕,任务名称:{},执行耗时:{}", quartzJob.getBeanName(), times);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("任务执行失败,任务名称:{}", quartzJob.getBeanName(), e);
            log.setIsSuccess(false);
            log.setTime(System.currentTimeMillis() - startTime);
            log.setExceptionDetail(ThrowableUtil.getStackTrace(e));

            //更新状态
            quartzJob.setIsPause(true);
            quartzJobService.updateJobPauseStatus(quartzJob);//强制暂停,方法里面会自动暂停调度

        } finally {
            log.setCreateTime(DateUtil.date().toTimestamp());
            //保存日志
            quartzLogService.create(log);
        }
    }
}
