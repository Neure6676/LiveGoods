package com.livegoods.search.controller;

import com.livegoods.commons.vo.LivegoodsResult;
import com.livegoods.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 搜索控制器
@RestController
@CrossOrigin
public class SearchController {
    @Autowired
    private SearchService searchService;
    @GetMapping("/search")
    public LivegoodsResult search(String city, String content, int page, @RequestParam(defaultValue = "4") int rows){
        return searchService.search(city, content, page, rows);
    }
}
