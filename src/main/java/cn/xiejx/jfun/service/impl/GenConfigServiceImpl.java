package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.GenConfigMapper;
import cn.xiejx.jfun.entity.GenConfig;
import cn.xiejx.jfun.service.GenConfigService;
import cn.xiejx.jfun.service.GeneratorService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 谢镜勋
 * @Date 2019/4/1
 */
@Service
public class GenConfigServiceImpl extends ServiceImpl<GenConfigMapper, GenConfig> implements GenConfigService {
    @Override
    public GenConfig findById(Long id) {
        return baseMapper.selectById(id);
    }
}
