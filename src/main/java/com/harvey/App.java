package com.harvey;


import com.harvey.Impl.UserServiceImpl;
import com.harvey.Impl.UserShow;
import com.harvey.pojo.User;
import com.harvey.processor.FixMyBean;
import com.harvey.service.UserService;
import com.harvey.utils.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 * @author Harvey Blocks
 */
public class App {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext(
                             "mybatisBean.xml")
        ) {//https://github.com/2023fzu/spring-test

            UserShow bean =
                    applicationContext
                            .getBean(UserShow.class);
            bean.show();
        }

    }



}
