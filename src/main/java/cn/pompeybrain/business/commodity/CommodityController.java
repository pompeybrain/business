package cn.pompeybrain.business.commodity;

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

    @RequestMapping(value = "/", method = RequestMethod.POST)

    public List<Map<String, String>> getAll() {
        List<Map<String, String>> resList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, String> resMap = new HashMap<>();
            resMap.put("" + i, "content" + i);
            resList.add(resMap);
        }
        return resList;
    }

}
