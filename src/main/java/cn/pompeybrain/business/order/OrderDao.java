package cn.pompeybrain.business.order;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 订单数据库接口
 * Created by Administrator on 2017/5/13 0013.
 */

@Mapper
public interface OrderDao {

    @Insert("insert into order (consumer_id, consumer_name, commodities, total, credit, payments, status, create_user_id, create_time, update_time) VALUES (#{consumerId}, #{consumerName}, #{commodities}, #{total}, #{credit}, #{payments}, #{status}, #{createUserId}, #{createTime}, #{updateTime});")
    @Options(useGeneratedKeys = true)
    int add(Order order);

    @Select("select * from order where id = #{id}")
    Order findById(int id);

    @Select("select * from order;")
    List<Order> findAll();

    @Update("update order set credit =  #{credit}, payments = #{payments}, status = #{status}, update_time = #{updateTime} where id = #{id};")
    int update(Order order);

}
