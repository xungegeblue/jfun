package ${package}.service.dto;

import lombok.Data;
<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>



@Data
public class ${className}DTO{
<#if columns??>
    <#list columns as column>
        <#if column.columnComment != ''>
        /**
         * ${column.columnComment}
         */
        </#if>
         private ${column.columnType} ${column.changeColumnName};
    </#list>
</#if>
}
