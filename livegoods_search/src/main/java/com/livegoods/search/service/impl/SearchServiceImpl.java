package com.livegoods.search.service.impl;

import com.livegoods.commons.vo.LivegoodsResult;
import com.livegoods.search.dao.ItemDao4ES;
import com.livegoods.search.pojo.Item4ES;
import com.livegoods.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.stereotype.Service;

// 搜索服务实现
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ItemDao4ES itemDao4ES;

    /**
     * 搜索商品逻辑
     * @param city 城市
     * @param content 搜索关键字
     * @param page 第几页， 从0开始
     * @param rows 每页查询多少行
     * @return
     */
    @Override
    public LivegoodsResult search(String city, String content, int page, int rows) {
        // 搜索商品数据
        AggregatedPage<Item4ES> resultPage =
                this.itemDao4ES.queryForPage(city, content, page, rows);

        // 构建返回结果对象。
        LivegoodsResult result = LivegoodsResult.ok(resultPage.getContent());
        if(page < (resultPage.getTotalPages() - 1)) { // 查询的当前页码小于总计页码
            result.setHasMore(true);
        }else{
            result.setHasMore(false);
        }
        return result;
    }
}
