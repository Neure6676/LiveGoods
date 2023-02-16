package com.livegoods.recommendation.service;

import com.livegoods.commons.vo.LivegoodsResult;

// 热门推荐服务接口
public interface RecommendationService {
    /**
     * 查询热门推荐商品信息， 查询条件是所在城市
     * 要保证查询的返回结果数据个数为4。
     * 如果所在城市的热门推荐商品数量大于4，查询前4条数据。查询条件是城市、是否推荐；根据推荐的排序字段降序排列
     * 如果所在城市的热门推荐商品数量小于4，查询其他城市的热门推荐数据，补足4条。
     * 所有城市的热门推荐数据总计不足4条数据，使用托底数据补足数据。
     * @param city 城市
     * @return
     */
    LivegoodsResult getRecommendation(String city);
}
