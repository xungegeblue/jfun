package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.QuartzLogMapper;
import cn.xiejx.jfun.entity.QuartzLog;
import cn.xiejx.jfun.service.QuartzLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class QuartzLogServiceImpl extends ServiceImpl<QuartzLogMapper, QuartzLog> implements QuartzLogService {
    @Override
    public void create(QuartzLog log) {
        baseMapper.insert(log);
    }
}
