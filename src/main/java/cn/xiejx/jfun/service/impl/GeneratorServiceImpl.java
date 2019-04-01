package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.GeneratorMapper;
import cn.xiejx.jfun.entity.GenConfig;
import cn.xiejx.jfun.service.GeneratorService;
import cn.xiejx.jfun.service.vo.ColumnInfo;
import cn.xiejx.jfun.service.vo.TableInfo;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/4/1
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    GeneratorMapper generatorMapper;

    @Override
    public IPage<TableInfo> getTables(String name, Page page) {
        IPage<TableInfo> tables = generatorMapper.getTables(page, name);
        return tables;
    }

    @Override
    public List<ColumnInfo> getColumnInfo(String tableName) {
        List<ColumnInfo> columns = generatorMapper.getColumns(tableName);
        return columns;
    }

    /**
     * 进行代码生成
     *
     * @param genConfig   生成器
     * @param tableName   需要生成的表名称
     * @param columnInfos 需要生成的列设置
     */
    @Override
    public void generator(GenConfig genConfig, String tableName, List<ColumnInfo> columnInfos) {

    }
}
