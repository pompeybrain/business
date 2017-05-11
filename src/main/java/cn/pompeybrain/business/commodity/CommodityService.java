package cn.pompeybrain.business.commodity;

import cn.pompeybrain.business.category.CategoryDao;
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

    /*
    * 按照可用分类获取商品列表
    * */
    public List<Map<String, List>> findAll() {

        List<Map<String, List>> result = new ArrayList<>();

        List<String> categories = categoryDao.findAvailable();

        for (int i = 0; i < categories.size(); i++) {
            Map<String, List> categoryMap = new HashMap<>();
            List<Commodity> commodityList = new ArrayList<>();
            categoryMap.put(categories.get(i), commodityList);
            result.add(categoryMap);
        }

        List<Commodity> rawCommodities = commodityDao.findAll();

        for (Commodity commodity : rawCommodities) {
            int index = categories.indexOf(commodity.getCategory());
            if (index != -1) {
                result.get(index).get(commodity.getCategory()).add(commodity);
            }
        }
        return result;
    }

    Commodity findById(int id) {
        return commodityDao.findById(id);
    }

    Commodity create(Commodity commodity) {
        BaseUtil.setCommon(commodity);
        commodityDao.add(commodity);
        return commodity;
    }

    int delete(int id) {
        return commodityDao.delete(id);
    }


}
