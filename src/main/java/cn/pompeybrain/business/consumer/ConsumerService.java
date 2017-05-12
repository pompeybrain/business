package cn.pompeybrain.business.consumer;

import cn.pompeybrain.business.commodity.Commodity;
import cn.pompeybrain.business.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户表逻辑
 * Created by pompey on 2017/5/13.
 */
@Service
public class ConsumerService {

    @Autowired
    ConsumerDao consumerDao;

    Consumer findById(int id) {
        return consumerDao.findById(id);
    }

    Consumer create(Consumer consumer) {
        BaseUtil.setCommon(consumer);
        consumerDao.add(consumer);
        return consumer;
    }

    int delete(int id) {
        return consumerDao.delete(id);
    }

    int update(Consumer consumer) {
        return consumerDao.update(consumer);
    }

    //    need fix
    List<Consumer> search() {
        return null;
    }
}
