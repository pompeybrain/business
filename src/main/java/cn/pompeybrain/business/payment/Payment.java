package cn.pompeybrain.business.payment;

import cn.pompeybrain.business.util.BaseBean;

/**
 * 付款记录类
 * Created by Administrator on 2017/5/15 0015.
 */
public class Payment extends BaseBean {
    private int consumerId;
    private int type;
    private double money;
    private String refOrders;
}
