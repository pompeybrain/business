package cn.pompeybrain.business.commodity;

import java.util.Date;

/**
 * 商品bean
 * Created by pompey on 2017/4/27.
 */
public class Commodity {
    private int id;
    private String name;
    private double cost;
    private double price;
    private int inventory;
    private int createUserId;
    private Date createTime;
    private Date updateTime;
}
