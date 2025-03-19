package com.github.anicmv.service.impl;

import cn.hutool.json.JSON;
import com.github.anicmv.pojo.SuperBed;
import com.github.anicmv.service.RandomImageService;
import com.github.anicmv.utils.SuperBedUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
public class RandomImageServiceImpl implements RandomImageService {
    @Override
    public JSON fetchSuperBed(SuperBed superBed) {
        try {
            return SuperBedUtils.getImages(superBed);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String randomUrl(JSON json) {
        String urlStr = json.getByPath("docs.url").toString();
        String[] urls = urlStr.substring(urlStr.indexOf('[') + 1, urlStr.lastIndexOf(']')).split(", ");

        Random random = new Random();
        int index = random.nextInt(urls.length);
        return urls[index];
    }


}
