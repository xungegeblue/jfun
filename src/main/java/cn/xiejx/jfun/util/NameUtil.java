package cn.xiejx.jfun.util;

/**
 * @Author 谢镜勋
 * @Date 2019/4/8
 */
public class NameUtil {
    private static final char SEPARATOR = '_';

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String toCapitalizeCamelCaseLower(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String t = toCapitalizeCamelCase(s);
        return t.substring(0, 1).toLowerCase() + t.substring(1, t.length());
    }

    public static void main(String[] args) {
        String a =  "Aaa_bb_cc";
        System.out.println(toCapitalizeCamelCaseLower(a));
    }
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
