package cn.pompeybrain.business.order;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * 订单数据库接口
 * Created by Administrator on 2017/5/13 0013.
 */

@Mapper
public interface OrderDao {

    @Insert("insert into `order` (consumer_id, consumer_name, commodities, total, credit, payments, status, create_user_id, create_time, update_time) VALUES (#{consumerId}, #{consumerName}, #{commodities}, #{total}, #{credit}, #{payments}, #{status}, #{createUserId}, #{createTime}, #{updateTime});")
    @Options(useGeneratedKeys = true)
    int add(Order order);

    @Select("select * from `order` where id = #{id}")
    Order findById(@Param("id") int id);

    @Select("select * from `order` where consumer_id = #{consumerId}")
    List<Order> findByConsumer(@Param("consumerId") int consumerId);

    @Select("select * from `order`;")
    List<Order> findAll();

    @Update("update `order` set credit =  #{credit}, payments = #{payments}, status = #{status}, update_time = #{updateTime} where id = #{id};")
    int update(Order order);

    @SelectProvider(type = OrderSqlProvider.class, method = "findCountByCondition")
    int searchCount(Map<String, Object> condition);

    @SelectProvider(type = OrderSqlProvider.class, method = "findByCondition")
    List<Order> search(Map<String, Object> condition);

    class OrderSqlProvider {
        public String findCountByCondition(Map<String, Object> condition) {
            String sql = new SQL() {
                {
                    SELECT("count(*)");
                    FROM("`order`");
                    WHERE("consumer_name like #{consumerName}");
                    if (condition.get("createStart") != null) {
                        WHERE("create_time between #{createStart} and #{createEnd}");
                    }
                    if (condition.get("updateStart") != null) {
                        WHERE("update_time between #{updateStart} and #{updateEnd}");
                    }
                }
            }.toString();
            return sql;
        }

        public String findByCondition(Map<String, Object> condition) {
            String sql = new SQL() {
                {
                    SELECT("*");
                    FROM("`order`");
                    WHERE("consumer_name like #{consumerName}");
                    if (condition.get("createStart") != null) {
                        WHERE("create_time between #{createStart} and #{createEnd}");
                    }
                    if (condition.get("updateStart") != null) {
                        WHERE("update_time between #{updateStart} and #{updateEnd}");
                    }
                    ORDER_BY("update_time DESC");
                }
            }.toString() + " limit #{offset}, #{pageSize}";
            return sql;
        }
    }
}
