package cn.xiejx.jfun.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable {
    private Integer uid;

    @NotBlank
    private String username;//帐号
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String password; //密码;
    private String salt;//加密密码的盐
    private String email;//邮箱
    private String avatar;//头像
    private Date createTime;//创建时间
    private int state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    private List<String> roles;// 一个用户具有多个角色
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }


    public User simpleInfo(){
        User u = new User();
        u.setUid(this.getUid());
        u.setName(this.getName());
        u.setUsername(this.getUsername());
        u.setState(this.getState());
        u.setRoles(this.getRoles());
        return u;
    }
}
