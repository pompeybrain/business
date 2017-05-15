package cn.pompeybrain.business.inventory;

import cn.pompeybrain.business.util.BaseBean;

/**
 * 库存表类
 * Created by Administrator on 2017/5/15 0015.
 */
public class Inventory extends BaseBean {
    private int commodityId;
    private int oldInventory;
    private int addition;
    private double amount;
    private double cost;
    private int newInventory;

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getOldInventory() {
        return oldInventory;
    }

    public void setOldInventory(int oldInventory) {
        this.oldInventory = oldInventory;
    }

    public int getAddition() {
        return addition;
    }

    public void setAddition(int addition) {
        this.addition = addition;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNewInventory() {
        return newInventory;
    }

    public void setNewInventory(int newInventory) {
        this.newInventory = newInventory;
    }
}
