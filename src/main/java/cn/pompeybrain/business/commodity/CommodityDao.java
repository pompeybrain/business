package cn.pompeybrain.business.commodity;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybatis 接口
 * Created by Administrator on 2017/5/10 0010.
 */

@Mapper
public interface CommodityDao {

    @Select("select * from commodity;")
    List<Commodity> findAll();

}
