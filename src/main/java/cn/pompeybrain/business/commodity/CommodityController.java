package cn.pompeybrain.business.commodity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 商品控制器
 * Created by pompey on 2017/5/9.
 */
@RestController

@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityDao commodityDao;

    @RequestMapping(value = "/test")
    public List<Map<String, String>> test() {
        List<Map<String, String>> resList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, String> resMap = new HashMap<>();
            resMap.put("" + i, "content" + i);
            resList.add(resMap);
        }
        return resList;
    }

    @RequestMapping(value = "/list")
    public List<Commodity> list() {
        List<Commodity> commodities = commodityDao.findAll();
        return commodities;
    }

}
