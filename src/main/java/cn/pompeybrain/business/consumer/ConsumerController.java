package cn.pompeybrain.business.consumer;

import cn.pompeybrain.business.order.Order;
import cn.pompeybrain.business.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 客户接口
 * Created by Administrator on 2017/5/13 0013.
 */

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Consumer> list(@RequestBody Map<String, Object> condition) {
        return consumerService.search(condition);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Consumer get(@PathVariable int id) {
        return consumerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    Consumer create(@RequestBody Consumer consumer) {
        consumerService.create(consumer);
        return consumer;
    }

    @RequestMapping(value = "/repay/{id}", method = RequestMethod.POST)
    int repay(@PathVariable int id, @RequestBody Map<String, Object> repayForm) {
        System.out.println(id);
        System.out.println(repayForm);
        List<Integer> orderIds = (List<Integer>) repayForm.get("orders");
        double repayment = Double.valueOf(repayForm.get("money").toString());
        return consumerService.repay(id, orderIds, repayment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    int update(@PathVariable int id, @RequestBody Consumer consumer) {
        if (!BaseUtil.checkId(id, consumer))
            return 0;
        return consumerService.update(consumer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    int delete(@PathVariable int id) {
        return consumerService.delete(id);
    }
}
