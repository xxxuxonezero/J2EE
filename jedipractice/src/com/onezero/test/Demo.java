package com.onezero.test;

import com.onezero.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Demo {
    @Test
    public void test1() {
//        获取连接
        Jedis jedis = new Jedis("localhost", 6379);
//        操作
        jedis.set("username", "zhangsan");
        jedis.get("name");
//        关闭连接
        jedis.close();
    }

    @Test
    public void test2() {
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        jedis.get("name");
        jedis.sadd("age","1","2");
//        归还连接
        jedis.close();

    }
    @Test
    public void test3() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();

    }
}
