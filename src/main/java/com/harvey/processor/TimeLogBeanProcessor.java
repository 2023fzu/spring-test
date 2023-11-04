package com.harvey.processor;

import com.harvey.Impl.UserServiceImpl;
import com.harvey.service.UserService;
import com.harvey.utils.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : TImeLogBeanProcessor
 * @date : 2023/11/03 00:44
 **/
public class TimeLogBeanProcessor implements BeanPostProcessor, BeanFactoryPostProcessor {
    private ConfigurableListableBeanFactory factory;


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        this.factory = factory;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    //使用动态代理对Bean进行增强
    // 返回proxy对象,
    // 进而存储到单例池SingletonObjects中
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    // 1. 输出开始时间
                    Log.info(sdf.format(new Date()) + "开始");
                    // 2.执行目标方法
                    Object result = method.invoke(bean, args);
                    Log.info(beanName + "." + method.getName());
                    // 3.输出结束时间
                    Log.info(sdf.format(new Date()) + "结束");
                    return result;
                }
        );
    }

}