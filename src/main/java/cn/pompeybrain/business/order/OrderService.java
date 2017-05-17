package cn.pompeybrain.business.order;

import cn.pompeybrain.business.util.BaseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 订单逻辑
 * Created by Administrator on 2017/5/13 0013.
 */

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    ObjectMapper objectMapper;

    public int create(Map orderForm) throws IOException {
        Order order = new Order();
        Map consumerMap = (Map) orderForm.get("consumer");
        order.setConsumerId((Integer) consumerMap.get("id"));
        order.setConsumerName(consumerMap.get("name").toString());
        List<Map<String, String>> commodities = objectMapper.readValue(orderForm.get("commodities").toString(), List.class);
        order.setCommodities(orderForm.get("commodities").toString());

        order.setTotal(Double.valueOf(orderForm.get("totalAmount").toString()));
        order.setCredit(Double.valueOf(orderForm.get("payResult").toString()));
        List<Map<String, String>> payments = new ArrayList<>();
        Map<String, String> payment = new HashMap<>();
        payment.put("money", orderForm.get("payment").toString());
        payment.put("type", "order");
        payments.add(payment);
        order.setPayments(objectMapper.writeValueAsString(payments));
        order.setStatus((Integer) orderForm.get("status"));
        BaseUtil.setCommon(order);
//        orderDao.add(order);
        return order.getId();
    }


    public Map<String, Object> search(Map<String, Object> condition) {
        int pageNo = Integer.parseInt(condition.get("pageNo").toString());
        int pageSize = Integer.parseInt(condition.get("pageSize").toString());
        int offset = (pageNo - 1) * pageSize;
        if (offset < 0) {
            offset = 0;
        }
        condition.put("offset", offset);
        Map<String, Object> dbResult = new HashMap<>();
        dbResult.put("totalRows", orderDao.searchCount(condition));
        dbResult.put("orders", orderDao.search(condition));
        return dbResult;
    }
}
