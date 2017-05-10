package cn.pompeybrain.business.commodity;

import cn.pompeybrain.business.category.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品相关逻辑
 * Created by Administrator on 2017/5/10 0010.
 */
public class CommodityService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CommodityDao commodityDao;

    public List<Map<String, Object>> findAll() {

        String[] categories = categoryDao.findAvailable();

        List<Map<String, Object>> commdoties = new ArrayList<>();
        List<Commodity> rawCommodities = commodityDao.findAll();

        String currentCategory = "";
        List<Commodity> categoryCommodities = new ArrayList<>();
        Map<String, Object> categoryCommodityMap = new HashMap<>();
//
//        for (Commodity commodity : rawCommodities) {
//            if ((!commodity.getCategory().equals(currentCategory)) && categoryCommodities.size() > 0) {
//                commdoties.add(categoryCommodityMap);
//                categoryCommodityMap = new HashMap<>();
//            } else {
//
//            }
//        }
        return commdoties;
    }
}
