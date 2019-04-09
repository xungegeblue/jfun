package cn.xiejx.jfun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author jie
 * @date 2018-11-24
 */
@Data
@TableName("log")
@NoArgsConstructor
public class Log {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 描述
     */
    private String description;

    /**
     * 方法名
     */
    private String method;

    /**
     * 参数
     */
    private String params;

    /**
     * 日志类型
     */
    @TableField(value = "log_type")
    private String logType;

    /**
     * 请求ip
     */
    @TableField(value = "request_ip")
    private String requestIp;

    /**
     * 请求耗时
     */
    private Long time;

    /**
     * 异常详细
     */
    @TableField(value = "exception_detail")
    private String exceptionDetail;

    /**
     * 创建日期
     */
    @TableField(value = "create_time")
    private Timestamp createTime;
    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}
