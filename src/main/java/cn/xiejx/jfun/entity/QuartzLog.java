package cn.xiejx.jfun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-01-07
 */
@Data
@TableName("quartz_log")
public class QuartzLog implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务名称
     */
    @TableField("job_name")
    private String jobName;

    /**
     * Bean名称
     */
    @TableField("baen_name")
    private String beanName;

    /**
     * 方法名称
     */
    @TableField("method_name")
    private String methodName;

    /**
     * 参数
     */
    @TableField("params")
    private String params;

    /**
     * cron表达式
     */
    @TableField("cron_expression")
    private String cronExpression;

    /**
     * 状态
     */
    @TableField("is_success")
    private Boolean isSuccess;

    /**
     * 异常详细
     */
    @TableField("exception_detail")
    private String exceptionDetail;

    /**
     * 耗时（毫秒）
     */
    private Long time;

    /**
     * 创建日期
     */
    @TableField("create_time")
    private Timestamp createTime;
}
