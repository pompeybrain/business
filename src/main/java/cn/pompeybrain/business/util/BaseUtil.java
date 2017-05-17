package cn.pompeybrain.business.util;


import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * BaseBean 的工具类
 * Created by Administrator on 2017/5/11 0011.
 */
public class BaseUtil {
    public static void setCommon(BaseBean baseBean) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createTime = LocalDateTime.now().format(formatter);
        String updateTime = LocalDateTime.now().format(formatter);
        baseBean.setCreateTime(createTime);
        baseBean.setUpdateTime(updateTime);
        baseBean.setCreateUserId(1); // 模拟当前用户为1
    }

    public static boolean checkId(int id, BaseBean baseBean) {
        if (id != baseBean.getId()) {
            return false;
        }
        return true;
    }

    public static void updateTime(BaseBean baseBean) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String updateTime = LocalDateTime.now().format(formatter);
        baseBean.setUpdateTime(updateTime);
    }

    private static void copyFieldsToMap(Field[] fields, Object obj, Map<String, Object> map) {
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象obj中属性fields[i]对应的值
                Object o = fields[i].get(obj);
                if (o != null)
                    map.put(varName, o);
                // System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static Map<String, Object> copyToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Class<?> currentClass = obj.getClass();
        Class<?> superClass = obj.getClass().getSuperclass();
        Field[] fields = currentClass.getDeclaredFields();
        Field[] superFields = superClass.getDeclaredFields();
        fields = concat(fields, superFields);
//        copyFieldsToMap(superFields, obj, map); //拷贝父类属性
        copyFieldsToMap(fields, obj, map); //拷贝子类属性
        return map;
    }
}
