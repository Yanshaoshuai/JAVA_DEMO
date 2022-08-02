package com.javademo.common.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public RegexUtil(){}
    public static boolean regexCheck(String str, String regex, int flags) {
        if (StringUtils.isAnyEmpty(str, regex)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex, flags);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
    public static boolean checkEmail(String str){
        // 邮箱验证规则
        String regEx = "[A-Za-z0-9_]{5,}[@][0-9a-z]{2,5}[.][a-z]{2,3}";
        return  regexCheck(str,regEx,0);
    }
    public static boolean checkName(String str){
        // 用户名验证规则 只包含中文、英文、下划线
        String regEx = "^[一-龥A-Za-z0-9_]{1,10}$";
        return  regexCheck(str,regEx,0);
    }
    public static boolean checkPsw(String str){
        //检查密码， 密码(长度在6~30之间，只能包含字母、数字和下划线)：
        String regEx = "^[A-Za-z0-9_]{6,30}$";
        return  regexCheck(str,regEx,0);
    }
}
