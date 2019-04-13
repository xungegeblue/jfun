package cn.xiejx.jfun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 邮件配置类，数据存覆盖式存入数据存
 * @author jie
 * @date 2018-12-26
 */
@Data
@TableName("email_config")
public class EmailConfig implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     *邮件服务器SMTP地址
     */
    @NotBlank
    private String host;

    /**
     * 邮件服务器SMTP端口
     */
    @NotBlank
    private String port;

    /**
     * 发件者用户名，默认为发件人邮箱前缀
     */
    @NotBlank
    private String user;

    @NotBlank
    private String pass;

    /**
     * 收件人
     */
    @NotBlank
    @TableField("from_user")
    private String fromUser;

    /**
     * 是否使用ssl
     * 1：是
     * 0：否
     */
    @NotNull //不使用@NotBlank
    @TableField(value = "ssl_enable")
    private Integer sslEnable;
}
