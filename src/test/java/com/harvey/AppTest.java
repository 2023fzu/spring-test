package com.harvey;

import junit.framework.TestCase;
import org.junit.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger("JedisLog");
    private Jedis jedis;

    /**
     * Jedis快速入门
     */
    @Before
    public void setUp() {
        //建立连接
        jedis = new Jedis("0.0.0.0", 6379);

        //设置密码?设置?不是输入?
        //jedis.auth("123456");
        //报错说我没有设置密码,我真的醉了qwq,我不明白啊qwq,完全按着网上来的啊啊啊qwq

        //选择库
        jedis.select(0);//默认0号库
        LOGGER.info("Connect Succeed.");

    }

    @Test
    public void test() {

        LOGGER.info("-----------String----------");
        LOGGER.info("String set=" + jedis.set("name", "施涵"));
        LOGGER.info("String get=" + jedis.get("name"));
        LOGGER.info("------------Hash----------");
        LOGGER.info("long hSet=" + jedis.hset("User:1", "name", "Jack"));
        LOGGER.info("long hSet=" + jedis.hset("User:1", "age", "12"));
        LOGGER.info("long hSet=" + jedis.hset("User:1", "gender", "男"));
        LOGGER.info("Map User:1=" + jedis.hgetAll("User:1"));
        LOGGER.info("--------------------------");
    }

    @After
    public void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
        LOGGER.info("Close Succeed");
    }
}




