package com.onezero.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工具类
 * 加载配置文件，配置连接池参数
 * 提供获取连接的方法
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
//        读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
//        加载配置文件
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
        jedisPool = new JedisPool(jedisPoolConfig, pro.getProperty("hosts"), Integer.parseInt(pro.getProperty("port")));

    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


}
