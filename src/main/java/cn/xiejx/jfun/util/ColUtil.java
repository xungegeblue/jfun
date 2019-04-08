package cn.xiejx.jfun.util;

import cn.hutool.setting.dialect.Props;


/**
 * sql字段转java
 *
 * @author miv
 * @date 2019年4月8日
 */
public class ColUtil {

    /**
     * 转换mysql数据类型为java数据类型
     *
     * @param type
     * @return
     */
    public static String cloToJava(String type) {
        Props config = getConfig();
        return config.getProperty(type, "unknowType");
    }

    /**
     * 获取配置信息
     */
    public static Props getConfig() {
        Props props = new Props("generator.properties");
        return props;
    }
}
