package com.harvey.factory;

import com.harvey.Impl.UserServiceImpl;
import com.harvey.service.UserService;
import com.harvey.utils.Log;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : MyBeanFactory
 * @date : 2023/10/30 15:25
 **/
public class MyBeanFactory implements FactoryBean<UserService> {
    public MyBeanFactory(){
//        Log.info("Factory 惨遭实例化");
    }

    public UserService getObject() throws Exception {
//        Log.info("Factory getObject(),启动");
        return new UserServiceImpl();
    }

    public Class<?> getObjectType() {
//        Log.info("Factory getObjectType(),启动");
        return UserService.class;
    }
}
