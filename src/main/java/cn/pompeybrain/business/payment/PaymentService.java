package cn.pompeybrain.business.payment;

import cn.pompeybrain.business.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 付款服务，内部接口
 * Created by Administrator on 2017/5/15 0015.
 */

@Service
public class PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    public int create(int consumerId, double money, String refOrders, String type) {
        Payment payment = new Payment();
        payment.setConsumerId(consumerId);
        payment.setType(type);
        payment.setMoney(money);
        payment.setRefOrders(refOrders);
        BaseUtil.setCommon(payment);
        return paymentDao.add(payment);
    }
}
