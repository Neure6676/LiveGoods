package com.livegoods.recommendation.dao;

import com.zerek.livegoods.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface ItemDao  {
    List<Item> selectItemToRecommend(Query query);
}
