package cn.xiejx.jfun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-01-07
 */
@Data
@TableName("quartz_job")
public class QuartzJob implements Serializable {

    public static final String JOB_KEY = "JOB_KEY";

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 定时器名称
     */
    @TableField("job_name")
    private String jobName;

    /**
     * Bean名称
     */
    @TableField("bean_name")
    @NotBlank
    private String beanName;

    /**
     * 方法名称
     */
    @TableField("method_name")
    @NotBlank
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
    @NotBlank
    private String cronExpression;

    /**
     * 状态
     */
    @TableField("is_pause")
    private Boolean isPause = false;

    /**
     * 备注
     */
    @NotBlank
    private String remark;

    /**
     * 创建日期
     */
    @TableField("update_time")
    private Timestamp updateTime;

    public interface Update{}
}