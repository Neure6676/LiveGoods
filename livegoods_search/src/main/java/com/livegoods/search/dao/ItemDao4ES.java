package com.livegoods.search.dao;

import com.livegoods.search.pojo.Item4ES;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;

import java.util.List;

public interface ItemDao4ES {
    // 分页查询
    AggregatedPage<Item4ES> queryForPage(String city, String content, int page, int rows);
    // 批量数据新增到ES
    void batchIndex(List<Item4ES> items);
    // 单数据新增到ES
    void index(Item4ES item);
}

