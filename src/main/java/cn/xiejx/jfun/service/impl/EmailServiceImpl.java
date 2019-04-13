package cn.xiejx.jfun.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.entity.EmailConfig;
import cn.xiejx.jfun.service.EmailService;
import cn.xiejx.jfun.service.vo.EmailVo;
import cn.xiejx.jfun.dao.EmailMapper;
import cn.xiejx.jfun.util.DesUtils;
import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 谢镜勋
 * @Date 2019/4/13
 */
@Service
public class EmailServiceImpl extends ServiceImpl<EmailMapper, EmailConfig> implements EmailService {


    /**
     * 修改email配置
     *
     * @param emailConfig 新的email设置
     * @param old         旧的email设置
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmailConfig update(EmailConfig emailConfig, EmailConfig old) {
        try {
            //生成密钥
            byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

            if (!emailConfig.getPass().equals(old.getPass())) {
                // 对称加密
                DesUtils des = new DesUtils();
                emailConfig.setPass(des.encrypt(emailConfig.getPass()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseMapper.updateById(emailConfig);
        return emailConfig;
    }

    @Override
    public EmailConfig find() {
        return baseMapper.selectById(1L);
    }

    @Override
    public void send(EmailVo emailVo, EmailConfig emailConfig) throws Exception {
        if (emailConfig == null) {
            throw new BadRequestException("请先配置，再操作");
        }
        /**
         * 封装
         */
        MailAccount account = new MailAccount();
        account.setHost(emailConfig.getHost());//主机
        account.setPort(Integer.parseInt(emailConfig.getPort()));//端口
        account.setAuth(true);
        account.setSslEnable(true);//25端口的话关闭这个ssl

        account.setUser(emailConfig.getUser()); //用户名
        try {
            // 对称解密
            DesUtils des = new DesUtils();
            account.setPass(des.decrypt(emailConfig.getPass())); // 密码
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
        //ssl方式发送
        if(emailConfig.getSslEnable().equals("1")){
            account.setSslEnable(true);
        }else{
            account.setSslEnable(false);
        }

        String content = emailVo.getContent();
        /**
         * 发送
         */
        account.setFrom(emailConfig.getFromUser()); //发件人邮箱
        try {
            MailUtil.send(account, emailVo.getTos(), emailVo.getSubject(), content, true);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
//        DesUtils des = new DesUtils();
//        System.out.println(des.encrypt("migpsamwkybbbcgi"));
//        des = new DesUtils();
//        System.out.println(des.decrypt(des.encrypt("migpsamwkybbbcgi")));
//        System.out.println("准备发送邮件...");
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
//        account.setSslEnable(false);
//        account.setPort(25);

        account.setSslEnable(true);
        account.setPort(465);
        account.setAuth(true);
        account.setFrom("787824374@qq.com");
        account.setUser("787824374@qq.com");
        account.setAuth(true);
        account.setPass("abmbwzivlvdkbdgi");
        MailUtil.send(account, CollUtil.newArrayList("787824374@qq.com"), "测试", "邮件来自jfun测试", true);
        System.out.println("发送邮件完毕..");


    }
}
