package cn.pompeybrain.business.category;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * category 数据库接口
 * Created by Administrator on 2017/5/10 0010.
 */
@Mapper
public interface CategoryDao {

    @Select("select name from category where available = 1;")
    List<String> findAvailable();

    @Select("select * from category;")
    List<Category> findAll();

    @Select("select * from category where id = #{id}")
    Category findById(int id);

    @Insert("INSERT INTO category (name, description, unit, available, create_user_id, create_time, update_time) VALUES (#{name},#{description},#{unit},#{available},#{createUserId},#{createTime},#{updateTime});")
    @Options(useGeneratedKeys = true)
    int add(Category category);

    @Delete("delete from category where id = #{id};")
    int delete(int id);

    @Update("update category set name = #{name}, description = #{description}, unit = #{unit}, available = #{available}, update_time = #{updateTime} where id = #{id};")
    int update(Category category);
}
