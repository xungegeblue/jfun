package cn.xiejx.jfun.service;


import cn.xiejx.jfun.entity.QuartzJob;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface QuartzJobService {
    QuartzJob create(QuartzJob job);

    List<QuartzJob> findByIsPause(boolean pause);

    IPage<QuartzJob> queryAll(QuartzJob job, Page pae);

    void edit(QuartzJob job);

    void updateJobPauseStatus(QuartzJob quartzJob);

    void exec(QuartzJob job);

    QuartzJob findById(Long id);

    void deleteJob(QuartzJob byId);
}
