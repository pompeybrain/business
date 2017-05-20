package cn.pompeybrain.business.consumer;

import cn.pompeybrain.business.order.Order;
import cn.pompeybrain.business.order.OrderService;
import cn.pompeybrain.business.payment.PaymentService;
import cn.pompeybrain.business.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户表逻辑
 * Created by pompey on 2017/5/13.
 */
@Service
public class ConsumerService {

    @Autowired
    private ConsumerDao consumerDao;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    public Consumer findById(int id) {
        return consumerDao.findById(id);
    }

    public Consumer create(Consumer consumer) {
        BaseUtil.setCommon(consumer);
        consumerDao.add(consumer);
        return consumer;
    }

    public int repayOrders(int id, List<Integer> orderIds, double repayment) {

        StringBuilder refOrders = new StringBuilder();

        //处理订单
        for (int orderId : orderIds) {
            Order order = orderService.findById(orderId);
            if (repayment > order.getCredit()) {
                repayment -= order.getCredit();
                order.setCredit(0);
                order.setPayments(order.getPayments() + repayment + ",");
                order.setStatus(1); // 订单状态完成
                orderService.update(order);
                refOrders.append(orderId).append(",");
            } else if (repayment > 0) {
                order.setCredit(order.getCredit() - repayment);
                order.setPayments(order.getPayments() + repayment + ",");
                orderService.update(order);
                refOrders.append(orderId).append(",");
            } else {
                break;
            }
        }
        //付款记录
        paymentService.create(id, repayment, refOrders.substring(0, refOrders.length() - 2), "repay");

        //处理客户
        return repay(id, repayment);
    }

    public int repay(int id, double repayment) {
        Consumer consumer = consumerDao.findById(id);
        double oldCredit = consumer.getCredit();
        if (repayment > oldCredit || oldCredit <= 0) {
            return 0;
        }
        consumer.setCredit(oldCredit - repayment);
        return update(consumer);
    }

    public int delete(int id) {
        return consumerDao.delete(id);
    }

    public int update(Consumer consumer) {
        BaseUtil.updateTime(consumer);
        return consumerDao.update(consumer);
    }

    public Map<String, Object> search(Map<String, Object> condition) {
        int pageNo = Integer.parseInt(condition.get("pageNo").toString());
        int pageSize = Integer.parseInt(condition.get("pageSize").toString());
        int offset = (pageNo - 1) * pageSize;
        if (offset < 0) {
            offset = 0;
        }
        condition.put("offset", offset);
        int counts = consumerDao.searchCount(condition);
        List<Consumer> consumers = consumerDao.findByCondition(condition);
        Map<String, Object> result = new HashMap<>();
        result.put("consumers", consumers);
        result.put("totalRows", counts);
        return result;
    }
}
