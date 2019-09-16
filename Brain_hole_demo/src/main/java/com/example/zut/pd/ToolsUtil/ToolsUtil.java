package com.example.zut.pd.ToolsUtil;

import com.example.zut.pd.dao.domain.ReturnDomain;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ToolsUtil {

    private ReturnDomain returnDomain=new ReturnDomain();

    //电话号验证   定义正则表达式
    public String DetectPhone(String phone) {
        //phone默认值为0,即为null
        if (phone.equals("0"))
            //返回参数为空
            return returnDomain.getR3();
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        //匹配成功  返回执行成功
        if (Pattern.matches(regex, phone))
            return returnDomain.getR1();
        //匹配失败  返回执行失败
        else
            return returnDomain.getR2();
    }

    //邮箱验证   定义正则表达式
    public String DetectEmail(String email) {
        //email默认值为0,即为null
        if (email.equals("0"))
            //返回参数为空
            return returnDomain.getR3();
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher mat = pattern.matcher(email);
        //匹配成功
        if (mat.find())
            return returnDomain.getR1();
        //匹配失败
        else
            return returnDomain.getR2();
    }

    /*
    手机号和邮箱在满足条件下
           最多只能有一个为空
           传0即代表无参数,为默认值
     */
    /*
    返回false
    * 1.都返回为执行失败
    *  手机号和邮箱不符合格式
    * 2.存在其中一个出现true但是为空的情况下
    *  手机号为空,邮箱不符合格式
    *  邮箱为空,手机号不符合格式
    * 3.两个都返回参数为空
    *  手机号和邮箱为空
    * */

    public boolean flag(String phone, String email) {
        //手机邮箱是否符合规定(包含内置为空返回为true)
        String flag_phone = DetectPhone(phone);
        String flag_email = DetectEmail(email);
        //手机号和邮箱都为空
        if (flag_phone.equals(returnDomain.getR3())&&flag_email.equals(returnDomain.getR3()))
            return false;
            //排除存在空值
        else if((flag_phone.equals(returnDomain.getR3())&&flag_email.equals(returnDomain.getR2()))
                ||(flag_email.equals(returnDomain.getR3())&&flag_phone.equals(returnDomain.getR2()))
                ||(flag_phone.equals(returnDomain.getR3())&&flag_email.equals(returnDomain.getR3())))
            return false;
        else
            return true;
/*        if (flag_phone1 == false && flag_email1 == true)
            return false;
            //排除因为空值而造成的返回true的条件
        else if ((flag_phone1 == true && flag_email2 == false)
                || (flag_email1 == true && flag_phone2 == false)
                || (flag_phone1 == true && flag_email1 == true)) {
            return false;
        } else
            return true;*/
    }
}
