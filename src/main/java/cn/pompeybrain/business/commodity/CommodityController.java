package cn.pompeybrain.business.commodity;

import cn.pompeybrain.business.inventory.Inventory;
import cn.pompeybrain.business.inventory.InventoryDao;
import cn.pompeybrain.business.util.BaseUtil;
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


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> list() {
        Map<String, Object> result = commodityService.findWithCategory();
        return result;
    }

    @RequestMapping(value = "/option", method = RequestMethod.GET)
    public List<Map<String, Object>> option() {
        return commodityService.findOptions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Commodity get(@PathVariable int id) {
        return commodityService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    int create(@RequestBody Commodity commodity) {
        return commodityService.create(commodity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    int update(@PathVariable int id, @RequestBody Commodity commodity) {
        if (!BaseUtil.checkId(id, commodity))
            return 0;
        return commodityService.update(commodity);
    }

    @RequestMapping(value = "/addInventory/{id}", method = RequestMethod.POST)
    int addInventory(@PathVariable int id, @RequestBody Inventory inventory) {
        return commodityService.addInventory(id, inventory);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    int delete(@PathVariable int id) {
        return commodityService.delete(id);
    }


}
