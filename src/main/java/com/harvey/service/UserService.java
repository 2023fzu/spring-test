package com.harvey.service;

import com.harvey.utils.Log;
import org.apache.ibatis.builder.InitializingObject;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

public interface UserService extends InitializingBean, ApplicationContextAware, BeanNameAware, BeanFactoryAware {
    @Override
    void afterPropertiesSet() throws Exception;

    void setUserDao(UserDao userDao);
    void destroy114514();
    void show();
    void init114514();
}
