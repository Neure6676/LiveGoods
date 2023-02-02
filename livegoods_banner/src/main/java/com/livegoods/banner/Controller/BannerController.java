package com.livegoods.banner.Controller;

import com.livegoods.banner.Service.BannerService;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin  // From 80 port, access to 9000 port
public class BannerController {
    @Autowired
    private BannerService bannerService;


    /**
     *
     * order:descent of creat time, first 6
     *
     * This method is for operate query resources of the banner
     * Return a JSON
     * @return
     * succeed:{"status":status code 200, "results":["image url",""]}
     * failed:{"status":status code 500, "msg":"error message"}
     */
    @GetMapping("/banner")
    public LivegoodsResult banner() {
        return bannerService.getBanners();
    }
}
