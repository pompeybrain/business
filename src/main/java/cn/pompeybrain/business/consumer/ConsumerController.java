package cn.pompeybrain.business.consumer;

import cn.pompeybrain.business.commodity.CommodityService;
import cn.pompeybrain.business.user.User;
import cn.pompeybrain.business.user.UserDao;
import cn.pompeybrain.business.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
}
