package com.harvey.mapper;

import com.harvey.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : UserMapper
 * @date : 2023/11/02 13:32
 **/
public interface UserMapper {
    //在接口写sql语句对应的对应方法
    List<User> selectAll();
    //注意是List ,因为select *
    List<User> selectById2(@Param("id") int id);
    List<User> sortBy(String columns);
    void addUser(User user);
    /*
     * 又了键值对就不会有对不上的了
     * 所以参数列表顺序可以乱
     * */
    List<User> selectByCondition(
            @Param("name") String name,
            @Param("age") int age,
            @Param("gender") String gender
    );
    List<User> selectByCondition(User user);
    List<User> selectByCondition(Map map);
    List<User> selectByConditionSingle(Map map);
    int update(User user);
    void delById(int id);
    void delByIds(int[] ids);
}
