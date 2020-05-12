package com.onezero.dao.impl;

import com.onezero.dao.ProvinceDao;
import com.onezero.domain.Province;
import com.onezero.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceImpl implements ProvinceDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql="select id,name from district where pid=1";
        List<Province> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return query;
    }
}
