package com.livegoods.recommendation.controller;

import com.livegoods.commons.vo.LivegoodsResult;
import com.livegoods.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热门推荐控制器
 */
@RestController
@CrossOrigin
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public LivegoodsResult getRecommendation(String city){
        return recommendationService.getRecommendation(city);
    }
}
