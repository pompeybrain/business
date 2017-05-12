package cn.pompeybrain.business.consumer;

import org.apache.ibatis.annotations.*;

import java.util.List;

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
    Consumer findById(int id);

    @Select("select * from consumer;")
    List<Consumer> findAll();

    //    need add if support
    @Select("select * from consumer where name like '%#{name}%' limit #{limitation};")
    List<Consumer> findByName(@Param("name") String name, @Param("limitation") int limitation);

    @Delete("delete from consumer where id = #{id};")
    int delete(int id);

    @Update("UPDATE consumer SET name = #{name}, phone = #{phone}, address = #{address}, credit = #{credit}, update_time = #{updateTime} where id = #{id}")
    int update(Consumer consumer);
}
