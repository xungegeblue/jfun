package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.exection.EntityExistException;
import cn.xiejx.jfun.dao.${className}Mapper;
import cn.xiejx.jfun.entity.${className};
import cn.xiejx.jfun.service.${className}Service;
import cn.xiejx.jfun.service.dto.${className}DTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
/**
 * @Author ${author}
 * @Date ${date}
 */
@Slf4j
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}> implements ${className}Service {
    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    public ${className}DTO create(${className} ${classNameLower}){
        if(${classNameLower}.getId()!=null){
            throw new BadRequestException("新添加的对象不可以有ID");
        }
        ${classNameLower}Mapper.insert(${classNameLower});
        ${className}DTO ${classNameLower}DTO = new ${className}DTO();
        BeanUtils.copyProperties(${classNameLower},${classNameLower}DTO);
        return ${classNameLower}DTO;
    }
    @Override
    public IPage<${className}DTO> select${className}Page(Page<${className}> page,${className}DTO ${classNameLower}DTO){
        IPage<${className}> dbPage = ${classNameLower}Mapper.select${className}Page(page,${classNameLower}DTO);
        IPage<${className}DTO> pages = new Page();
        pages.setCurrent(dbPage.getCurrent());
        pages.setPages(dbPage.getPages());
        pages.setSize(dbPage.getSize());
        pages.setTotal(dbPage.getTotal());

        List<${className}DTO> dtos = new ArrayList<>();
            dbPage.getRecords().forEach(it->{
            ${className}DTO dto = new ${className}DTO();
            BeanUtils.copyProperties(it,dto);
            dtos.add(dto);
        });
        pages.setRecords(dtos);
        return pages;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(${className}DTO ${classNameLower}DTO){
        ${className} ${classNameLower} = ${classNameLower}Mapper.selectById(${classNameLower}DTO.getId());
        if(${classNameLower}==null){
            throw new EntityExistException(${className}.class,"id",${classNameLower}.getId()+"");
        }
        //TODO  手动把DTO对象的属性设置到${classNameLower}
        ${classNameLower}Mapper.updateById(${classNameLower});
    }

    @Override
    public void delete(Long id){
        ${classNameLower}Mapper.deleteById(id);
    }
}