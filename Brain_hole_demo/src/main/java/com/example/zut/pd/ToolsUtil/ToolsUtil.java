package com.example.zut.pd.ToolsUtil;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ToolsUtil {
    //电话号验证   定义正则表达式
    public boolean DetectPhone(String phone) {
        //phone默认值为0,即为null
        if (phone.equals("0"))
            return true;
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        if (Pattern.matches(regex, phone))
            return true;
        else
            return false;
    }

    //邮箱验证   定义正则表达式
    public boolean DetectEmail(String email) {
        //email默认值为0,即为null
        if (email.equals("0"))
            return true;
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find())
            return false;
        else
            return true;
    }

    //手机号和邮箱最多只能有一个为空
    //0代表无参数
    public boolean flag(String phone, String email) {
        if (phone.equals("0") && email.equals("0"))
            return false;
        else {
            if ((DetectPhone(phone) == true && email.equals("0"))
                    || (phone.equals("0") && DetectEmail(email)==true)
                    || (DetectEmail(email) == true && DetectPhone(phone) == true))
                return true;
            else
                return false;
        }
    }
}
