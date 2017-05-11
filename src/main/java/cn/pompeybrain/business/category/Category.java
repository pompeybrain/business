package cn.pompeybrain.business.category;

import cn.pompeybrain.business.util.BaseBean;

import java.util.Date;

/**
 * 商品类别
 * Created by Administrator on 2017/5/10 0010.
 */
public class Category extends BaseBean {
    private int id;
    private String name;
    private String description;
    private String unit;
    private boolean available;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
