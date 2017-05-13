package cn.pompeybrain.business.commodity;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * mybatis 接口
 * Created by Administrator on 2017/5/10 0010.
 */

@Mapper
public interface CommodityDao {

    @Insert("INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time) VALUES (#{name},#{cost},#{price},#{unit},#{category},#{inventory},#{createUserId},#{createTime},#{updateTime});")
    @Options(useGeneratedKeys = true)
    int add(Commodity commodity);

    @Select("select * from commodity where id = #{id}")
    Commodity findById(int id);

    @Select("select * from commodity;")
    List<Commodity> findAll();

    @Delete("delete from commodity where id = #{id};")
    int delete(int id);

    @Update("update commodity set name = #{name}, cost = #{cost}, price = #{price}, unit = #{unit}, category = #{category}, update_time = #{updateTime} where id = #{id};")
    int update(Commodity commodity);

}
