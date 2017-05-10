package cn.pompeybrain.business.category;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * category 数据库接口
 * Created by Administrator on 2017/5/10 0010.
 */
@Mapper
public interface CategoryDao {

    @Select("select name from category where available = 1;")
    String[] findAvailable();

    @Select("select * from category;")
    List<Category> findAll();
}
