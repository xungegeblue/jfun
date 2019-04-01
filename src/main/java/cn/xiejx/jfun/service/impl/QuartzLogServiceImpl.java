package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.QuartzLogMapper;
import cn.xiejx.jfun.entity.QuartzLog;
import cn.xiejx.jfun.service.QuartzLogService;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //quartzLogMapper.selectPage(page, Wrappers.<QuartzLog>lambdaQuery().or())
        return null;
    }
}
