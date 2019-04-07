package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.GenConfig;

/**
 * @Author 谢镜勋
 * @Date 2019/4/1
 */
public interface GenConfigService {
    public GenConfig findById(Long id);

    GenConfig update(GenConfig genConfig);
}
