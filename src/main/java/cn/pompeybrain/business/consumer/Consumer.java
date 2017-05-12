package cn.pompeybrain.business.consumer;

import cn.pompeybrain.business.util.BaseBean;

/**
 * 客户类
 * Created by pompey on 2017/5/12.
 */
public class Consumer extends BaseBean {
    private String name;
    private String pohone;
    private String address;
    private double credit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPohone() {
        return pohone;
    }

    public void setPohone(String pohone) {
        this.pohone = pohone;
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
