package com.onezero.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onezero.dao.ProvinceDao;
import com.onezero.dao.impl.ProvinceImpl;
import com.onezero.domain.Province;
import com.onezero.service.ProvinceService;
import com.onezero.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao province=new ProvinceImpl();
    @Override
    public List<Province> findAll() {
        return province.findAll();
    }

    @Override
    public String findJedisByJson() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_str = jedis.get("province");
        if (province_str == null) {
            System.out.println("无数据");
            List<Province> list = province.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_str = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province", province_str);
        }else{
            System.out.println("有数据");
        }
        return province_str;
    }
}
