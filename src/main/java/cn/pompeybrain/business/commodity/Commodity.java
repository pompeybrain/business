package cn.pompeybrain.business.commodity;

import cn.pompeybrain.business.util.BaseBean;

import java.util.Date;

/**
 * 商品bean
 * Created by pompey on 2017/4/27.
 */
public class Commodity extends BaseBean {
    private int id;
    private String name;
    private double cost;
    private double price;
    private String unit;
    private String category;
    private int inventory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

}
