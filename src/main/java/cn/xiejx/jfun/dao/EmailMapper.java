package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.entity.EmailConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 谢镜勋
 * @Date 2019/4/13
 */
@Mapper
public interface EmailMapper extends BaseMapper<EmailConfig> {
}
