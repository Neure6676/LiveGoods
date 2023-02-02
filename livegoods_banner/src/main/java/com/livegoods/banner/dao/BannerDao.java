package com.livegoods.banner.dao;

import com.zerek.livegoods.Banner;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Data query
 */
public interface BannerDao {
     List<Banner> selectBanners(Query query);
}
