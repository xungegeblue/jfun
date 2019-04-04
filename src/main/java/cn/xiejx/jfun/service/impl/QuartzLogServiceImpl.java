package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.QuartzLogMapper;
import cn.xiejx.jfun.entity.QuartzLog;
import cn.xiejx.jfun.service.QuartzLogService;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class QuartzLogServiceImpl extends ServiceImpl<QuartzLogMapper, QuartzLog> implements QuartzLogService {
    @Autowired
    QuartzLogMapper quartzLogMapper;

    @Override
    public void create(QuartzLog log) {
        baseMapper.insert(log);
    }

    @Override
    public IPage<QuartzLog> queryAll(QuartzLog quartzLog, Page page) {
        if (quartzLog == null || (StringUtils.isEmpty(quartzLog.getJobName()) && quartzLog.getIsSuccess() == null)) {
            return quartzLogMapper.selectPage(page, null);
        } else {
            return quartzLogMapper.selectPage(page, Wrappers.<QuartzLog>lambdaQuery().or(
                    wapper -> {
                        wapper.eq(!StringUtils.isEmpty(quartzLog.getJobName()), QuartzLog::getJobName, quartzLog.getJobName());
                        wapper.eq(quartzLog.getIsSuccess() != null, QuartzLog::getIsSuccess, quartzLog.getIsSuccess());
                        return wapper;
                    }
            ));
        }

    }
}
