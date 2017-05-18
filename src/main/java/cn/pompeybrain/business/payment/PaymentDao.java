package cn.pompeybrain.business.payment;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 付款记录数据库接口
 * Created by Administrator on 2017/5/15 0015.
 */
@Mapper
public interface PaymentDao {

    @Insert("insert into payment_record (consumer_id, type, money, ref_orders, create_user_id, create_time) VALUES (#{consumerId}, #{type}, #{money}, #{refOrders}, #{createUserId}, #{createTime});")
    @Options(useGeneratedKeys = true)
    int add(Payment payment);

    @Select("select * from payment_record where id = #{id}")
    Payment findById(int id);

    @Select("select * from payment_record;")
    List<Payment> findAll();

    @Select("select * from payment_record where consumer_id = #{consumerId};")
    List<Payment> findByConsumer(@Param("consumerId") int consumerId);
}
