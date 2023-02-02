package com.livegoods.hotproduct.dao;

import com.zerek.livegoods.Item;
import org.springframework.data.mongodb.core.query.Query;


import java.util.List;

// 热销商品中的商品数据访问接口
// 热销商品中的商品数据访问接口
public interface ItemDao {
    // 查询热销商品的数据访问方法，根据销量排序，查询条件为城市。 查询只要4条数据。
    List<Item> getHotProduct(Query query);
}
