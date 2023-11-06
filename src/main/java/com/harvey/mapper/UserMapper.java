package com.harvey.mapper;

import com.harvey.pojo.User;

import java.util.List;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : UserMapper
 * @date : 2023/11/05 11:39
 **/
public interface UserMapper {
    List<User> findAll();
}
