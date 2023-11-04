package com.harvey;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : Test
 * @date : 2023/10/29 15:44
 **/
public class JedisConnectionFactoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger("JedisLog");
    private Jedis jedis;
    @Before
    public void testGetJedis(){
        jedis = JedisConnectionFactory.getJedis();
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
class JedisConnectionFactory{
    private static final JedisPool JEDIS_POOL;
    static {
        //配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        poolConfig.setMaxTotal(8);//最大连接数,最多允许几个连接
        poolConfig.setMaxIdle(8);//最大空闲连接
        poolConfig.setMinIdle(1);//最小空闲连接,一直没人访问,里面的内容就会被释放,直到为1
        poolConfig.setMaxWaitMillis(1000);//等待时间,参数为-1时表示无限制等待

        //创建连接池对象
        JEDIS_POOL = new JedisPool(
                poolConfig,
                "0.0.0.0",//主机名?不是主机IP吗?
                6379,
                1000//超时时间
                //,"123456"//密码
        );


    }
    public static Jedis getJedis(){
        return JEDIS_POOL.getResource();
    }
}
