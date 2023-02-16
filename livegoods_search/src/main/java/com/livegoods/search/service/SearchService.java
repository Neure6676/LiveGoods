package com.livegoods.search.service;

import com.livegoods.commons.vo.LivegoodsResult;

// 搜索服务接口
public interface SearchService {
    // 搜索服务方法
    LivegoodsResult search(String city, String content, int page, int rows);
}
