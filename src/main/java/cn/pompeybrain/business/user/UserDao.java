package cn.pompeybrain.business.user;

import cn.pompeybrain.business.commodity.Commodity;
import org.apache.ibatis.annotations.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 用户表数据库接口
 * Created by Administrator on 2017/5/12 0012.
 */
@Mapper
public interface UserDao {

    @Insert("INSERT INTO user (name, password_digest, phone, role, status, create_user_id, create_time, update_time) VALUES (#{name},#{passwordDigest},#{phone},#{role},#{status},#{createUserId},#{createTime},#{updateTime});")
    @Options(useGeneratedKeys = true)
    int add(User user);

    @Select("select * from user where id = #{id}")
    User findById(int id);

    @Select("select * from user where name = #{name} and password_digest = #{passwordDigest};")
    User findByNameAndPassword(@Param("name") String name, @Param("passwordDigest") String passwordDigest);

    @Select("select * from user;")
    List<User> findAll();

    @Delete("delete from user where id = #{id};")
    int delete(int id);

    @Update("update user set name = #{name}, password_digest = #{passwordDigest}, phone = #{phone}, status = #{status}, update_time = #{updateTime} where id = #{id};")
    int update(User user);
}
