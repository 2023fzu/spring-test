package com.harvey.service;

import com.harvey.pojo.User;
import org.springframework.beans.factory.InitializingBean;

public interface UserDao extends InitializingBean {

    boolean isFlag();


    void setFlag(boolean flag);


    void init();

    @Override
    void afterPropertiesSet() throws Exception;
}
