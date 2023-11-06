package com.harvey.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : HarveyBeanPostProcessor
 * @date : 2023/11/05 21:21
 **/
public class HarveyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("HarveyBeanPostProcessor执行");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
