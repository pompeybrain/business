package cn.pompeybrain.business.payment;

import cn.pompeybrain.business.util.BaseBean;

/**
 * 付款记录类
 * Created by Administrator on 2017/5/15 0015.
 */
public class Payment extends BaseBean {
    private int consumerId;
    private String type;
    private double money;
    private String refOrders;

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getRefOrders() {
        return refOrders;
    }

    public void setRefOrders(String refOrders) {
        this.refOrders = refOrders;
    }
}
