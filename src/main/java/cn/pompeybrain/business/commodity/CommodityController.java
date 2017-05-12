package cn.pompeybrain.business.commodity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 商品控制器
 * Created by pompey on 2017/5/9.
 */
@RestController

@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Map<String, List>> list() {
        List<Map<String, List>> commodities = commodityService.findAll();
        return commodities;
    }

    @RequestMapping(method = RequestMethod.POST)
    Commodity create(@RequestBody Commodity commodity) {
        commodityService.create(commodity);
        return commodity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    int delete(@PathVariable int id) {
        return commodityService.delete(id);
    }
}
