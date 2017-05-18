package cn.pompeybrain.business.inventory;

import cn.pompeybrain.business.commodity.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 库存变更记录表接口
 * Created by Administrator on 2017/5/15 0015.
 */
@Mapper
public interface InventoryDao {

    @Insert("INSERT INTO inventory_record (commodity_id, old_inventory, addition, amount, cost, new_inventory, create_user_id, create_time) VALUES (#{commodityId},#{oldInventory},#{addition},#{amount},#{cost},#{newInventory},#{createUserId},#{createTime});")
    @Options(useGeneratedKeys = true)
    int add(Inventory inventory);

    @Select("select * from inventory_record where id = #{id};")
    Inventory findById(@Param("id") int id);

    @Select("select * from inventory_record;")
    List<Inventory> findAll();

    @Select("select * from inventory_record where commodity_id = #{commodityId};")
    Inventory findByCommodity(@Param("commodityId") int commodityId);
}
