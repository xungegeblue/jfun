package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.QuartzLog;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface QuartzLogService {


    void create(QuartzLog log);

    IPage<QuartzLog> queryAll(QuartzLog quartzLog, Page page);
}
