package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.dao.QuartzJobMapper;
import cn.xiejx.jfun.quartz.QuartzManage;
import cn.xiejx.jfun.entity.QuartzJob;
import cn.xiejx.jfun.service.QuartzJobService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartzJobServiceImpl extends ServiceImpl<QuartzJobMapper,QuartzJob> implements QuartzJobService {


    @Autowired
    QuartzManage manage;

    @Override
    public QuartzJob create(QuartzJob job) {

        if(!CronExpression.isValidExpression(job.getCronExpression())){
            throw new BadRequestException("cron 表达式错误!");
        }
        int i = baseMapper.insert(job);
        //添加定时任务
        manage.andJob(job);
        return i>0?job:null;
    }

    @Override
    public List<QuartzJob> findByIsPause(boolean pause) {
        List<QuartzJob> jobs = baseMapper.selectList(Wrappers.<QuartzJob>lambdaQuery()
                .eq(QuartzJob::getIsPause,pause));
        return jobs;
    }

    @Override
    public void updateIsPause(QuartzJob job) {
        QuartzJob db = baseMapper.selectById(job.getId());
        db.setIsPause(job.getIsPause());
        baseMapper.updateById(db);
    }

}
