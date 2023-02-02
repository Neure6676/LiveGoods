package details.controller;

import com.zerek.livegoods.Item;
import details.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品详情控制器
 */
@RestController
@CrossOrigin
public class DetailsController {
    @Autowired
    private DetailsService detailsService;

    /**
     * 商品详情查询方法。 主键查询商品。
     * @param id
     * @return
     */
    @GetMapping("/details")
    public Item findDetails(String id){
        return detailsService.getDetails(id);
    }
}
