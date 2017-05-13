package cn.pompeybrain.business.consumer;

import cn.pompeybrain.business.util.BaseBean;

/**
 * 客户类
 * Created by pompey on 2017/5/12.
 */
public class Consumer extends BaseBean {
    private String name;
    private String phone;
    private String address;
    private double credit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
