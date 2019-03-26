package cn.xiejx.jfun;

import cn.xiejx.jfun.util.MD5Util;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Author 谢镜勋
 * @Date 2019/3/26
 */
public class TestShiro {
    public static void main(String[] args) {

        String algorithmName = "md5";
        String username = "xxx";
        String password = "123456";
        String salt1 = username;
        String salt2 =  "0b0adf8f1985836833e9d6664d7ecfba";//new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;
        SimpleHash hash = new SimpleHash(algorithmName, password,
                salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();
        System.out.println(encodedPassword); //620dbcd7525d5143cf1bed1a4861390b


        System.out.println(MD5Util.encrypt("123456","xxx0b0adf8f1985836833e9d6664d7ecfba",2));


    }
}
