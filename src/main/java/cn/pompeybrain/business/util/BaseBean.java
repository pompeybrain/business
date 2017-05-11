package cn.pompeybrain.business.util;

/**
 * 具有相同字段的父类
 * Created by Administrator on 2017/5/11 0011.
 */
public class BaseBean {
    private int id;
    private int createUserId;
    private String createTime;
    private String updateTime;

    public int getCreateUserId() {
        return createUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
