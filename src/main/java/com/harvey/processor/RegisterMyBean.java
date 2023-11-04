package com.harvey.processor;

import com.harvey.annotation.MyComponent;
import com.harvey.utils.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : RegisterMyBean
 * @date : 2023/11/02 21:00
 **/
public class RegisterMyBean implements BeanDefinitionRegistryPostProcessor {
    public void myMethod(){
//        Log.info("RegisterMyBean:MyMethod,不会启动qwq");
    }
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        Log.info("RegisterMyBean:Registry,启动!");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
//        Log.info("RegisterMyBean:Factory,启动!");
    }
}
