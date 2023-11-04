package com.harvey.utils;

import com.harvey.utils.BaseClassScanUtils;
import com.harvey.utils.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.io.IOException;
import java.util.Map;

public class MyComponentUtil implements BeanDefinitionRegistryPostProcessor {
    private static final String BASE_PACKAGE = "com/harvey";

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //通过扫描工具,扫描指定包及其子包下所有的类,收集使用@MyComponent注解的类
        Map<String, Class> beanMap = null;
        try {
            beanMap = BaseClassScanUtils.scanMyComponentAnnotation(BASE_PACKAGE);
        } catch (IOException | ClassNotFoundException e) {
            Log.error(e);
        }
        //循环注册
        beanMap.forEach((beanName, bean) -> {
            //获得beanClassName
            String className = bean.getName();
            //创建Bean Definition
            BeanDefinition beanDefinition = new RootBeanDefinition();
            beanDefinition.setBeanClassName(className);
            //注册
            registry.registerBeanDefinition(beanName, beanDefinition);
        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}