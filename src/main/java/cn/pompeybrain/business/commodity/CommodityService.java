package cn.pompeybrain.business.commodity;

import cn.pompeybrain.business.category.CategoryDao;
import cn.pompeybrain.business.inventory.Inventory;
import cn.pompeybrain.business.inventory.InventoryDao;
import cn.pompeybrain.business.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品相关逻辑
 * Created by Administrator on 2017/5/10 0010.
 */
@Service
public class CommodityService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private InventoryDao inventoryDao;

    /*
    * 按照可用分类获取商品列表
    * */
    public Map<String, Object> findWithCategory() {

        Map<String, Object> result = new HashMap<>();

        List<String> categories = categoryDao.findAvailable();

        List<List<Commodity>> commodities = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {
            List<Commodity> commodityList = new ArrayList<>();
            commodities.add(commodityList);
        }

        List<Commodity> rawCommodities = commodityDao.findAll();

        for (Commodity commodity : rawCommodities) {
            int index = categories.indexOf(commodity.getCategory());
            if (index != -1) {
                commodities.get(index).add(commodity);
            }
        }
        result.put("categories", categories);
        result.put("commodities", commodities);
        return result;
    }

    /*
    * 提供前端嵌套选择的商品数组
    * */
    public List<Map<String, Object>> findOptions() {
        List<Map<String, Object>> result = new ArrayList<>();
        List<String> categories = categoryDao.findAvailable();
        List<Commodity> rawCommodities = commodityDao.findAll();
        List<List<Map<String, String>>> middleCommodities = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {
            middleCommodities.add(new ArrayList<>());
        }

        for (Commodity commodity : rawCommodities) {
            int index = categories.indexOf(commodity.getCategory());
            if (index != -1) {
                Map<String, String> commodityMap = new HashMap<>();
                commodityMap.put("value", String.valueOf(commodity.getId()));
                commodityMap.put("label", commodity.getName());
                middleCommodities.get(index).add(commodityMap);
            }
        }

        for (int i = 0; i < categories.size(); i++) {
            Map<String, Object> categoryMap = new HashMap<>();
            categoryMap.put("value", categories.get(i));
            categoryMap.put("label", categories.get(i));
            categoryMap.put("children", middleCommodities.get(i));
            result.add(categoryMap);
        }
        return result;
    }


    public Commodity findById(int id) {
        return commodityDao.findById(id);
    }

    int create(Commodity commodity) {
        BaseUtil.setCommon(commodity);
        commodityDao.add(commodity);
        return commodity.getId();
    }

    int delete(int id) {
        return commodityDao.delete(id);
    }

    public int update(Commodity commodity) {
        BaseUtil.updateTime(commodity);
        return commodityDao.update(commodity);
    }

    int addInventory(int id, Inventory inventory) {
        Commodity commodity = findById(id);
        int newInventory = inventory.getNewInventory();
        double newCost = (commodity.getCost() * commodity.getInventory() + inventory.getAmount()) / newInventory;
        commodity.setInventory(newInventory);
        commodity.setCost(newCost);
        update(commodity);

        BaseUtil.setCommon(inventory);
        inventoryDao.add(inventory);
        return inventory.getId();
    }
}
