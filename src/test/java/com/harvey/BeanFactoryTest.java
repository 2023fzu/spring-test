package com.harvey;

import com.harvey.Impl.UserDaoImpl;
import com.harvey.service.UserDao;
import com.harvey.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @auth1or : HarveyBlocks
 * @version : 1.0
 * @className : BeanFactoryTest
 * @date : 2023/10/30 00:28
 **/

public class BeanFactoryTest {
    @Test
    public void testFactory() {
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext("beans.xml")){
            TestLogger.info(applicationContext.getBean("myBeanFactory"));
        }

        //UserService userService2 = (UserService) beanFactory.getBean("userService");
        //TestLogger.LOGGER.info("userService2成功创建"+userService2);

        //userService2.show();


        //根据id获取Bean对象,这一步不强转,类型擦出了也没事
//        UserDao userDao =(UserDao) beanFactory.getBean("userDao1");
//        TestLogger.LOGGER.info(""+userDao);

        //需要业务层调用Dao层


    }
    @Test
    public void testFixRootDao(){
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext("beans.xml")){
            TestLogger.info(applicationContext.getBean("rootDao"));
        }
    }
    @Test
    public void testFixMyBean(){
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext("beans.xml")){
            TestLogger.info(applicationContext.getBean("userService"));
        }catch (Exception e){
            TestLogger.error(e.getMessage());
        }
    }
}
