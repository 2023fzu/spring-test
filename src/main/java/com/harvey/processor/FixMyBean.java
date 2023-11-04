package com.harvey.processor;

import com.harvey.Impl.UserDaoImpl;
import com.harvey.annotation.MyComponent;
import com.harvey.utils.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : FixMyBean
 * @date : 2023/11/02 23:50
 **/
@MyComponent()
public class FixMyBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Log.info("FixMyBean:Before-> " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Log.info("FixMyBean:After-> " + beanName);
        return bean;
    }
}
