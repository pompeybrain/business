package cn.pompeybrain.business.order;

import cn.pompeybrain.business.commodity.Commodity;
import cn.pompeybrain.business.commodity.CommodityService;
import cn.pompeybrain.business.payment.Payment;
import cn.pompeybrain.business.payment.PaymentService;
import cn.pompeybrain.business.util.BaseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private CommodityService commodityService;
    @Autowired
    private PaymentService paymentService;

    @Autowired
    ObjectMapper objectMapper;

    public int create(Map orderForm) throws Exception {
        Order order = new Order();
        Map consumerMap = (Map) orderForm.get("consumer");
        int consumerId = (Integer) consumerMap.get("id");
        order.setConsumerId(consumerId);
        order.setConsumerName(consumerMap.get("name").toString());
        List<Map<String, Object>> commodities = objectMapper.readValue(orderForm.get("commodities").toString(), List.class);
        for (Map<String, Object> orderCommodity : commodities) {
            Commodity commodity = commodityService.findById((Integer) orderCommodity.get("id"));
            int oldInventory = commodity.getInventory();
            int decrease = Integer.parseInt(String.valueOf(orderCommodity.get("quantity")));
            if (oldInventory < decrease) {
                System.out.println("商品扣减超过库存");
                throw new Exception();
            } else {
                commodity.setInventory(oldInventory - decrease);
            }
            commodityService.update(commodity);
        }
        order.setCommodities(orderForm.get("commodities").toString());
        order.setTotal(Double.valueOf(orderForm.get("totalAmount").toString()));
        order.setCredit(Double.valueOf(orderForm.get("payResult").toString()));
        Double payment = Double.valueOf(orderForm.get("payment").toString());
        order.setPayments(payment + ",");
        order.setStatus((Integer) orderForm.get("status"));
        BaseUtil.setCommon(order);
        orderDao.add(order);

        Payment paymentRecord = new Payment();
        paymentRecord.setConsumerId(consumerId);
        paymentRecord.setMoney(payment);
        paymentRecord.setType("order");
        paymentRecord.setRefOrders(order.getId() + ",");
        paymentService.create(paymentRecord);
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
