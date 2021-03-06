package cn.pompeybrain.business.order;

import cn.pompeybrain.business.consumer.Consumer;
import cn.pompeybrain.business.consumer.ConsumerService;
import cn.pompeybrain.business.util.BaseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * 订单api接口
 * Created by Administrator on 2017/5/13 0013.
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int create(@RequestBody Map<String, Object> orderForm) {
        try {
            return orderService.create(orderForm);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Order> list() {
        return null;
    }

    @RequestMapping(value = "/getByConsumer/{consumerId}", method = RequestMethod.GET)
    public List<Order> getConsumerOrders(@PathVariable int consumerId) {
        return orderService.findByConsumer(consumerId);

    }

    @RequestMapping(value = "/repay/{id}", method = RequestMethod.GET)
    public int repay(@PathVariable int id, @RequestParam double repayment) {
        return orderService.repay(id, repayment);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Map<String, Object> search(@RequestBody Map<String, Object> conditon) {
        Map<String, Object> realCondition = new HashMap<>();
        realCondition.put("consumerName", "%" + conditon.get("consumerName") + "%");
        realCondition.put("pageNo", conditon.get("pageNo"));
        realCondition.put("pageSize", conditon.get("pageSize"));
        List<String> createTimes = (List<String>) conditon.get("createTime");
        if (createTimes.size() > 0) {
            realCondition.put("createStart", createTimes.get(0));
            realCondition.put("createEnd", createTimes.get(1));
        }
        List<String> updateTimes = (List<String>) conditon.get("updateTime");
        if (updateTimes.size() > 0) {
            realCondition.put("updateStart", createTimes.get(0));
            realCondition.put("updateEnd", createTimes.get(1));
        }

        Map<String, Object> result = orderService.search(realCondition);

        List<Order> orderList = (List<Order>) result.get("orders");

        List<Map<String, Object>> orderMapList = new ArrayList<>();
        for (Order order : orderList) {
            Map<String, Object> orderMap = BaseUtil.copyToMap(order);
            Consumer consumer = consumerService.findById(order.getConsumerId());
            orderMap.put("consumer", consumer);
            orderMapList.add(orderMap);
        }
        result.put("orders", orderMapList);
        return result;
    }


}
