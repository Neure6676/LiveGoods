package details.dao;

import com.zerek.livegoods.Item;

// 查询商品详情数据访问接口
public interface ItemDao {
    Item findItemById(String id);
}
