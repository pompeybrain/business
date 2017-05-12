package cn.pompeybrain.business.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
}
