package cn.pompeybrain.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 测试类，测试一些语法使用
 * Created by Administrator on 2017/5/11 0011.
 */
public class Test {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createTime = LocalDateTime.now().format(formatter);

        System.out.println("test");
        String testStr = "business/api/login";
        System.out.println(testStr.matches("(.*)/login$"));
//        System.out.println(createTime);
    }

}
