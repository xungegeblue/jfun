package cn.xiejx.jfun.service;

import cn.xiejx.jfun.entity.GenConfig;
import cn.xiejx.jfun.service.vo.ColumnInfo;
import cn.xiejx.jfun.service.vo.TableInfo;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/4/1
 */
public interface GeneratorService {
    IPage<TableInfo> getTables(String name, Page page);

    List<ColumnInfo> getColumnInfo(String tableName);

    void generator(GenConfig genConfig, String tableName, List<ColumnInfo> columnInfos);
}
