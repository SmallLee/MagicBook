package com.example.smalllee.myapplication;

/**
 * 描述：
 *
 * @author Create by lxn on 2018/12/24
 */
public class StringUtil {
    public static String toDBC(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\u3000') {
                chars[i] = ' ';
            } else if (chars[i] > '\uFF00' && chars[i] < '\uFF5F') {
                chars[i] = (char) (chars[i] - 65248);

            }
        }
        return new String(chars);
    }
}
