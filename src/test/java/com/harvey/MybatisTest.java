package com.harvey;

import com.harvey.mapper.UserMapper;
import com.harvey.Impl.UserShow;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : MybatisTest
 * @date : 2023/11/04 16:34
 **/
public class MybatisTest {
    @Test
    public void test() {
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext(
                             "mybatisBean.xml")
        ) {//https://github.com/2023fzu/spring-test

            UserShow bean =
                    applicationContext
                            .getBean(UserShow.class);
            System.out.println(bean);
        }
    }
    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext(
                             "beans.xml")
        ) {

            UserShow bean =
                    applicationContext
                            .getBean(UserShow.class);
            System.out.println(bean);
        }
    }
}
