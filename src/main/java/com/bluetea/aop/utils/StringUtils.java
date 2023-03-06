package com.bluetea.aop.utils;

/**
 * 自定义 StringUtil
 *
 * @author: NaturalCool
 * @date: 2023/3/6
 */
public class StringUtils extends org.springframework.util.StringUtils {
    /**
     * 判断多个字符串时候为空，当其中有一个为空时返回 false，都不为空时返回 true
     *
     * @param str 要判断的字符串
     * @return boolean
     */
    public static boolean isEmptys(String... str) {
        for (String s : str) {
            if (isEmpty(s))
                return false;
        }
        return true;
    }
}
