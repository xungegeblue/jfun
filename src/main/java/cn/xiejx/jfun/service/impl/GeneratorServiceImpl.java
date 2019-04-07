package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.GeneratorMapper;
import cn.xiejx.jfun.entity.GenConfig;
import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.GeneratorService;
import cn.xiejx.jfun.service.vo.ColumnInfo;
import cn.xiejx.jfun.service.vo.TableInfo;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 谢镜勋
 * @Date 2019/4/1
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    GeneratorMapper generatorMapper;

    @Override
    public IPage<TableInfo> getTables(String name, Page page) {
        IPage<TableInfo> tables = generatorMapper.getTables(page, name);
        return tables;
    }

    @Override
    public List<ColumnInfo> getColumnInfo(String tableName) {
        List<ColumnInfo> columns = new ArrayList<>();
        List<Map> map = generatorMapper.getColumns(tableName);
        map.forEach(m ->{
            String column_name = (String) m.get("column_name");
            String is_nullable = (String) m.get("is_nullable");
            String data_type = (String) m.get("data_type");
            String column_comment = (String) m.get("column_comment");
            String column_key = (String)m.get("column_key");
            ColumnInfo c = new ColumnInfo(column_name,is_nullable,data_type,column_comment,column_key,null,null);
            columns.add(c);
        });
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
