package cn.xiejx.jfun.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.dao.QuartzJobMapper;
import cn.xiejx.jfun.quartz.QuartzManage;
import cn.xiejx.jfun.entity.QuartzJob;
import cn.xiejx.jfun.service.QuartzJobService;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuartzJobServiceImpl extends ServiceImpl<QuartzJobMapper, QuartzJob> implements QuartzJobService {


    @Autowired
    QuartzManage quartzManage;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public QuartzJob create(QuartzJob job) {

        if (!CronExpression.isValidExpression(job.getCronExpression())) {
            throw new BadRequestException("cron 表达式错误!");
        }
        job.setUpdateTime(DateUtil.date().toTimestamp());
        int i = baseMapper.insert(job);
        //添加定时任务
        quartzManage.addJob(job);
        return i > 0 ? job : null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<QuartzJob> findByIsPause(boolean pause) {
        List<QuartzJob> jobs = baseMapper.selectList(Wrappers.<QuartzJob>lambdaQuery()
                .eq(QuartzJob::getIsPause, pause));
        return jobs;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public IPage<QuartzJob> queryAll(QuartzJob job, Page pae) {
        //对象里面如果jobName=null查询就出问题了
        return baseMapper.selectPage(pae, Wrappers.<QuartzJob>lambdaQuery().eq(StringUtils.isNotEmpty(job.getJobName()),QuartzJob::getJobName, job.getJobName()));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(QuartzJob resource) {
        if (!CronExpression.isValidExpression(resource.getCronExpression())) {
            throw new BadRequestException("cron 表达式错误");
        }
        resource.setUpdateTime(DateUtil.date().toTimestamp());
        baseMapper.updateById(resource);
        quartzManage.updateJobCron(resource);
    }

    //更新任务状态(如果任务需要暂停需要设置pause=true
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateJobPauseStatus(QuartzJob quartzJob) {
        if (quartzJob.getId() == null) {
            throw new BadRequestException("该任务不存在");
        }
        if (quartzJob.getIsPause()) {
            //暂停
            quartzManage.pauseJob(quartzJob);
        } else {
            //恢复
            quartzManage.resumeJob(quartzJob);
        }
        QuartzJob dbJob = baseMapper.selectById(quartzJob.getId());
        dbJob.setIsPause(quartzJob.getIsPause());
        baseMapper.updateById(dbJob);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void exec(QuartzJob job) {
        quartzManage.runJobNow(job);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public QuartzJob findById(Long id) {
        return baseMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteJob(QuartzJob quartzJob) {
        quartzManage.deleteJob(quartzJob);
        baseMapper.deleteById(quartzJob.getId());
    }


}
