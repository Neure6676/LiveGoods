package com.livegoods.banner.Service.impl;

import com.livegoods.banner.Service.BannerService;
import com.livegoods.banner.dao.BannerDao;
import com.livegoods.commons.vo.LivegoodsResult;
import com.zerek.livegoods.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * banner query implementation
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;


    /**
     * access MongoDB by DAO data access class
     * order: descend of creat time, first 4
     * @return
     */
    @Override
    public LivegoodsResult getBanners() {
        LivegoodsResult result = new LivegoodsResult();
        try {
            // query condition
            Query query = new Query();
            query.with(
                    PageRequest.of(0, 4,
                            Sort.by(Sort.Direction.DESC, "createTime"))
            );
            List<Banner> banners = bannerDao.selectBanners(query);

            // succeed
            result.setStatus(200);
            List<String> imgResults = new ArrayList<>();
            for(Banner banner : banners){
                imgResults.add(nginxPrefix+banner.getUrl());
            }
            result.setResults(imgResults);
        }catch (Exception e){
            e.printStackTrace();
            // failed
            result.setStatus(500);
            result.setMsg("Images access failed!");
        }

        return result;

    }
}
