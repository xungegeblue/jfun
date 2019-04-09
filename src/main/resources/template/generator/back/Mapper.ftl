package cn.xiejx.jfun.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import cn.xiejx.jfun.entity.${className};
import cn.xiejx.jfun.service.dto.${className}DTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * @Author ${author}
 * @Date ${date}
 */
@Mapper
public interface ${className}Mapper extends BaseMapper<${className}> {

    public IPage<${className}> select${className}Page (IPage<${className}> page,@Param(value = "${tableName}") ${className}DTO ${classNameLower}DTO);
}
