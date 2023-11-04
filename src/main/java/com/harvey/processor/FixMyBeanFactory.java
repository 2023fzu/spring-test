package com.harvey.processor;

import com.harvey.Impl.RootDaoImpl;
import com.harvey.utils.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : FixUserService
 * @date : 2023/11/02 16:48
 **/
public class FixMyBeanFactory implements BeanFactoryPostProcessor{

    /*@Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        Log.info("postProcessBeanFactory,启动!");
        BeanDefinition myBeanFactory = factory.getBeanDefinition("myBeanFactory");
        //不管xml里是id还是name!getBean("用到是什么名字"),这里就填什么名字

        Log.info("获取myBeanFactory");

        myBeanFactory.setBeanClassName("com.harvey.Impl.UserDaoImpl");
        //看看我这一手优秀的操作

        Log.info("把myBeanFactory硬生生改成了UserDaoImpl!");
    }*/
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        //动态注册BeanDefinition-RootDao
//        Log.info("postProcessBeanFactory,启动!");
        Class<RootDaoImpl> clazz = RootDaoImpl.class;
        BeanDefinition beanDefinition =
                new RootBeanDefinition();
                //这个Root可是和我一点关系够没有哦
        beanDefinition.setBeanClassName(clazz.getName());
//        Log.info(clazz);

        // 为什么一定要用强转?
        // factory的register...()方法只能将Bean注入objectSingleton里,和这里的目的不一样
        // DlbFactory是ClbFactory的子类,强的很,
        // 能注入到beanDefinitionMap里,GOOD
        DefaultListableBeanFactory dlbFactory = (DefaultListableBeanFactory) factory ;

        dlbFactory.registerBeanDefinition(
                "rootDao",
                beanDefinition
        );
//        Log.info("Fix Finished");
    }




}
