package com.harvey.Impl;

import com.harvey.mapper.UserMapper;
import com.harvey.pojo.User;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : UserShow
 * @date : 2023/11/04 16:59
 **/
public class UserShow {

    //注入UserMapper
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public void show(){
        for(User user:userMapper.findAll()){
            System.out.println(user);
        }
    }
}
