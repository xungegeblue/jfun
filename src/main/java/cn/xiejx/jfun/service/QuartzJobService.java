package cn.xiejx.jfun.service;


import cn.xiejx.jfun.entity.QuartzJob;

import java.util.List;

public interface QuartzJobService {
    QuartzJob create(QuartzJob job);

    List<QuartzJob> findByIsPause(boolean pause);

    void updateIsPause(QuartzJob job);
}
