package com.livegoods.banner.dao.impl;

import com.livegoods.banner.dao.BannerDao;
import com.zerek.livegoods.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Banner data access class
 * connect MongoDB
 */
@Repository
public class BannerDaoImpl implements BannerDao {

    @Autowired
    public MongoTemplate mongoTemplate;

    @Override
    public List<Banner> selectBanners(Query query) {
        List<Banner> result = mongoTemplate.find(query, Banner.class); //自动查找数据库中叫banner的表
        return result;
    }
}
