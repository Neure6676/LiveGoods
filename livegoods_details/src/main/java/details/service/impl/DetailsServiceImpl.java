package details.service.impl;

import com.zerek.livegoods.Item;
import details.dao.ItemDao;
import details.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 商品详情服务实现
@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    private ItemDao itemDao;
    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;

    /**
     * 主键查询商品。
     * 需要将商品中的图片地址，从相对路径修改为绝对路径。
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = "com:livegoods:details", key = "'getDetails('+#id+')'")
    public Item getDetails(String id) {
        // 主键查询
        Item item = itemDao.findItemById(id);
        // 把图片的相对路径修改成绝对路径。
        List<String> newImgs = new ArrayList<>();
        for(String img : item.getImgs()){
            newImgs.add(nginxPrefix + img);
        }
        item.setImgs(newImgs);

        return item;
    }
}
