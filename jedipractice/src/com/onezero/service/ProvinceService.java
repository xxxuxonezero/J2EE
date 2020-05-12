package com.onezero.service;

import com.onezero.domain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();

    public String findJedisByJson();
}
