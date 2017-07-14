package cn.pompeybrain.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pompey on 2017/7/14.
 */
public class Test {
    public static void main(String[] args) {
        String urlSb = "http://localhost:8088/business/api/user/";
        Pattern hostP = Pattern.compile("^(\\w+://[\\w|:]+)/");
        Matcher m = hostP.matcher(urlSb);
        if (m.find()) {
            System.out.println(m.group(1));
        } else {
            System.out.println("no match");
        }
    }
}
