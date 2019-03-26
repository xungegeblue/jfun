package cn.xiejx.jfun.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Author 谢镜勋
 * @Date 2019/3/26
 */
public class MD5Util {
    public static String encrypt(String originalData, String salt, int hashIterations) {
        SimpleHash hash = new SimpleHash("md5", originalData, salt, hashIterations);
        String encodedData = hash.toHex();
        return encodedData;
    }
    public static String getRandomSalt(){
        return new SecureRandomNumberGenerator().nextBytes().toHex();
    }
}
