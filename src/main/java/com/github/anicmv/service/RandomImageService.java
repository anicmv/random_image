package com.github.anicmv.service;

import cn.hutool.json.JSON;
import com.github.anicmv.pojo.SuperBed;

public interface RandomImageService {

    JSON fetchSuperBed(SuperBed superBed);

    String randomUrl(JSON json);

}
