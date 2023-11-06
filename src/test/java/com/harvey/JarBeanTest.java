package com.harvey;

import com.alibaba.druid.pool.DruidDataSource;
import com.harvey.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : DruidTest
 * @date : 2023/11/01 22:23
 **/
public class JarBeanTest {
    @Test
    public void druidTest() {
        DruidDataSource dataSource = new DruidDataSource();//实例化创建对象
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        TestLogger.info(dataSource);

        TestLogger.info("=========================");


        DruidDataSource druidDataSource = (DruidDataSource) new ClassPathXmlApplicationContext("JarBeans.xml").getBean("druidDataSource");
        TestLogger.info(druidDataSource);
    }

    @Test
    public void connectTest() throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "123456");//类似静态工厂方法


        TestLogger.info(conn);
        conn.close();
        TestLogger.info("==========================");
        /*Connection conn2 =
                (Connection) new ClassPathXmlApplicationContext("JarBeans.xml")
                        .getBean("connection");
        TestLogger.info(conn2);
        conn2.close();*/

    }

    @Test
    public void testData() throws ParseException {
        //目标:将一个时间的字符串转化成Date交给Spring来管理
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//类似实例工厂
        Date parse = sdf.parse("2023-11-2 12:00:00");//类似实例工厂方法
        TestLogger.info(parse);
        Date date = (Date) new ClassPathXmlApplicationContext("JarBeans.xml").getBean("date");
        TestLogger.info(date);

    }

    @Test
    public void testMybatis() throws IOException {
        //静态工厂方式
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");

        //无参构造实例化
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //实例工厂方法
        SqlSessionFactory factory = builder.build(resource);
        //实例工厂方法
        SqlSession session = factory.openSession();
        //实例工厂方法
        UserMapper userMapper = session.getMapper(
                //resource
                UserMapper.class);


        TestLogger.info(userMapper.findAll());

        TestLogger.info("================================");

        try (
                ClassPathXmlApplicationContext applicationContext =
                        new ClassPathXmlApplicationContext("JarBeans.xml")
        ) {
            UserMapper userMapper1 = (UserMapper)
                    applicationContext.getBean("userMapper");
            TestLogger.info(userMapper1.findAll());
        }
    }
}
