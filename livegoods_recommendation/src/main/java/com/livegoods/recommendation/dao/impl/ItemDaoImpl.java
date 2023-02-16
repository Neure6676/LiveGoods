package com.livegoods.recommendation.dao.impl;

import com.zerek.livegoods.Item;
import com.livegoods.recommendation.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 热门推荐 - 商品数据访问实现。
 */
@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询商品。
     * @param query
     * @return
     */
    @Override
    public List<Item> selectItemToRecommend(Query query) {
        return mongoTemplate.find(query, Item.class);
    }
}
