package com.livegoods.hotproduct.controller;

import com.livegoods.commons.vo.LivegoodsResult;
import com.livegoods.hotproduct.service.HotProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热销商品控制器
 */
@RestController
@CrossOrigin
public class HotProductController {
    @Autowired
    private HotProductService hotProductService;

    /**
     * 查询热销商品数据
     * @param city 查询条件， 城市
     * @return
     */
    @GetMapping("/hotProduct")
    public LivegoodsResult getHotProduct(String city){
        return hotProductService.getHotProducts(city);
    }
}
