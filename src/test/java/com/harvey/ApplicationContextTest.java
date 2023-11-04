package com.harvey;

import com.harvey.service.UserService;
import com.harvey.utils.Log;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : ApplicationContextTest
 * @date : 2023/10/30 01:42
 **/
public class ApplicationContextTest {
    @Test
    public void test(){
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext("beans.xml")){
            UserService userService =
                    (UserService) applicationContext.getBean("userService");
            TestLogger.info(userService);
        }
    }
    @Test
    public void test2(){
        Class<?> clazz = this.getClass();
        Log.info(clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1));
    }
    @Test
    public void test3(){

    }

}
