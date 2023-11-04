package com.harvey.Impl;

import com.harvey.service.UserDao;
import com.harvey.service.UserService;
import com.harvey.utils.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : UserServiceImpl
 * @date : 2023/10/30 00:25
 **/
public class UserServiceImpl implements UserService{
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Log.info("ApplicationContextAware:"+applicationContext.getClass().getSimpleName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        Log.info("BeanFactoryAware:"+beanFactory.getClass().getSimpleName());
    }

    @Override
    public void setBeanName(String s) {
        Log.info("BeanNameAware:"+s);
    }
    public void init114514(){
        Log.info("UserService:init114514(自定义初始方法)初始化中");
    }
    public void destroy114514(){
//        Log.info("用destroy114514()销毁中");
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

    private UserDao userDao;


    @Override
    public void afterPropertiesSet() throws Exception {
        Log.info("UserService:InitializingBean的接口方法");
    }

    //Bean工厂去调用 从容器中获取userDao设置到此处
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
        Log.info("userDao注入到UserServiceImpl");
    }

    public UserServiceImpl() {
//        Log.info("UserService无参构造");
    }
    public void show(){
//        Log.info("show()->"+userDao);
    }


}
