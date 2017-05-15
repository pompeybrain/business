package cn.pompeybrain.business.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单api接口
 * Created by Administrator on 2017/5/13 0013.
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int create() {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Order> list() {
        return null;
    }

    @RequestMapping(value = "{id}/repay", method = RequestMethod.PUT)
    public int repay() {
        return 0;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Order> search() {
        return null;
    }


}
