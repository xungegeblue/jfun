package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.service.vo.ColumnInfo;
import cn.xiejx.jfun.service.vo.TableInfo;
import cn.xiejx.jfun.vo.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/4/1
 */
@Mapper
public interface GeneratorMapper {

    @Select("select table_name tableName,create_time createTime from information_schema.tables where table_schema = (select database())")
    public IPage<TableInfo> getTables(Page page, @Param("name") String name);

    @Select("select column_name, is_nullable, data_type, column_comment, column_key from information_schema.columns where table_name=#{tableName} and table_schema = (select database()) order by ordinal_position")
    List<ColumnInfo> getColumns(@Param("tableName") String tableName);
}
