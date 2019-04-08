package ${package}.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>



@Data
@TableName(value = "${tableName}")
public class ${className}{
<#if columns??>
    <#list columns as column>
        <#if column.columnComment != ''>
        /**
         * ${column.columnComment}
         */
        </#if>
        <#if column.columnKey = 'PRI'>
        @TableId(type = IdType.AUTO)
        </#if>
         private ${column.columnType} ${column.changeColumnName};
    </#list>
</#if>
}
