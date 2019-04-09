package cn.xiejx.jfun.service;


import cn.xiejx.jfun.entity.${className};
import cn.xiejx.jfun.service.dto.${className}DTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;
/**
 * @Author ${author}
 * @Date ${date}
 */
public interface ${className}Service extends IService<${className}> {

    ${className}DTO create(${className} ${classNameLower});

    public IPage<${className}DTO> select${className}Page(Page<${className}> page,${className}DTO ${classNameLower}DTO);

    void update(${className}DTO ${classNameLower}DTO);

    void delete(Long id);
}