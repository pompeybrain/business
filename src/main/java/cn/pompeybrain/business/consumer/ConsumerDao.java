package cn.pompeybrain.business.consumer;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * Consumer数据库接口
 * Created by pompey on 2017/5/13.
 */

@Mapper
public interface ConsumerDao {

    @Insert("INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time) VALUES (#{name},#{phone},#{address},#{credit},#{createUserId},#{createTime},#{updateTime});")
    @Options(useGeneratedKeys = true)
    int add(Consumer consumer);

    @Select("select * from consumer where id = #{id}")
    Consumer findById(@Param("id") int id);

    @Select("select count(1) from consumer;")
    int count();

    @Delete("delete from consumer where id = #{id};")
    int delete(@Param("id") int id);

    @Update("UPDATE consumer SET name = #{name}, phone = #{phone}, address = #{address}, credit = #{credit}, update_time = #{updateTime} where id = #{id}")
    int update(Consumer consumer);


    @SelectProvider(type = UserSqlProvider.class, method = "findByCondition")
    List<Consumer> findByCondition(Map<String, Object> condition);

    class UserSqlProvider {
        public String findByCondition(Map<String, Object> condition) {
            String sql = new SQL() {
                {
                    SELECT("*");
                    FROM("consumer");
                    WHERE("name like #{name}");
                    WHERE("phone like #{phone}");
                    WHERE("address like #{address}");
                    ORDER_BY("update_time DESC");
                }
            }.toString() + " limit #{offset}, #{pageSize}";
            return sql;
        }
    }
}
