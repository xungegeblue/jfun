package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.dao.QuartzJobMapper;
import cn.xiejx.jfun.quartz.QuartzManage;
import cn.xiejx.jfun.entity.QuartzJob;
import cn.xiejx.jfun.service.QuartzJobService;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
    public void updateIsPause(QuartzJob job) {
        QuartzJob db = baseMapper.selectById(job.getId());
        db.setIsPause(job.getIsPause());
        baseMapper.updateById(db);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public IPage<QuartzJob> queryAll(QuartzJob job, Page pae) {
        return baseMapper.selectPage(pae, Wrappers.<QuartzJob>lambdaQuery().eq(QuartzJob::getJobName, job.getJobName()));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(QuartzJob resource) {
        if (!CronExpression.isValidExpression(resource.getCronExpression())) {
            throw new BadRequestException("cron 表达式错误");
        }
        baseMapper.updateById(resource);
        quartzManage.updateJobCron(resource);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateStatus(Long id) {
        QuartzJob quartzJob = baseMapper.selectById(id);
        if (quartzJob == null) {
            throw new BadRequestException("改任务不存在");
        }
        boolean isPause = quartzJob.getIsPause();
        if (isPause) {
            //恢复
            quartzManage.resumeJob(quartzJob);
        } else {
            //暂停
            quartzManage.pauseJob(quartzJob);
        }
        quartzJob.setIsPause(!isPause);
        baseMapper.updateById(quartzJob);
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
