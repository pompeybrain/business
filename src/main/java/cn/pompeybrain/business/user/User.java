package cn.pompeybrain.business.user;

import cn.pompeybrain.business.util.BaseBean;

/**
 * 用户类
 * Created by Administrator on 2017/5/12 0012.
 */
public class User extends BaseBean {
    private String name;
    private String passwordDigest;
    private String phone;
    private int role;
    private boolean status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
