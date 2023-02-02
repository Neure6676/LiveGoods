//package com.zerek.livegoods.mongodb;
//
//import com.zerek.livegoods.Banner;
//import com.zerek.livegoods.Item;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.*;
//
//@SpringBootTest(classes = {MongoDBApp.class})
//@RunWith(SpringRunner.class)
//public class TestData {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Test
//    public void insertItems() {
//        List<Item> items = new ArrayList<>();
//
//        Item item = new Item();
//        item.setCity("北京");
//        item.setHouseType("150 ㎡");
//        item.setImgs(
//                Arrays.asList(
//                        "group1/M00/00/00/CtM3B2O2_DuAW02hABLGy4zg5nA326.png",
//                        "group1/M00/00/00/CtM3B2O2_JGAdNoSAAjIobLVxBY563.png",
//                        "group1/M00/00/00/CtM3B2O2_LOAG7vvAAro9yfjOVw343.png"
//                )
//        );
//        item.setPrice(12000L);
//        item.setRecommendation(true);
//        item.setRecoSort((byte) 9);
//        item.setRentType("整租");
//        item.setSales(100L);
//        item.setTitle("北京高档公寓");
//        Map<String, String> info = new HashMap<>();
//        info.put("years", "2010");
//        info.put("type", "3室2厅");
//        info.put("level", "10/18层");
//        info.put("style", "精装修");
//        info.put("orientation", "南北通透");
//        item.setInfo(info);
//        items.add(item);
//
//        item = new Item();
//        item.setCity("北京");
//        item.setHouseType("230 ㎡");
//        item.setImgs(
//                Arrays.asList(
//                        "group1/M00/00/00/CtM3B2O2_M2APJA3AAuC467ZRns137.png",
//                        "group1/M00/00/00/CtM3B2O2_OeARTnEABS0Lvm4RSc779.png",
//                        "group1/M00/00/00/CtM3B2O2_QWAQuL4ABHVENCjbfU648.png"
//                )
//        );
//        item.setPrice(21000L);
//        item.setRecommendation(true);
//        item.setRecoSort((byte) 12);
//        item.setRentType("整租");
//        item.setSales(30L);
//        info = new HashMap<>();
//        info.put("years", "2007");
//        info.put("type", "5室3厅");
//        info.put("level", "2/2层");
//        info.put("style", "精装修");
//        info.put("orientation", "南北通透");
//        item.setInfo(info);
//        item.setTitle("北京联排别墅");
//        items.add(item);
//
//        item = new Item();
//        item.setCity("北京");
//        item.setHouseType("310 ㎡");
//        item.setImgs(
//                Arrays.asList(
//                        "group1/M00/00/00/CtM3B2O2_DuAW02hABLGy4zg5nA326.png",
//                        "group1/M00/00/00/CtM3B2O2_JGAdNoSAAjIobLVxBY563.png",
//                        "group1/M00/00/00/CtM3B2O2_LOAG7vvAAro9yfjOVw343.png"
//                )
//        );
//        item.setPrice(30000L);
//        item.setRecommendation(true);
//        item.setRecoSort((byte) 6);
//        item.setRentType("整租");
//        item.setSales(10L);
//        info = new HashMap<>();
//        info.put("years", "2013");
//        info.put("type", "6室4厅");
//        info.put("level", "3/3层");
//        info.put("style", "豪华装修");
//        info.put("orientation", "四面环海");
//        item.setInfo(info);
//        item.setTitle("北京独栋别墅");
//        items.add(item);
//
//        item = new Item();
//        item.setCity("北京");
//        item.setHouseType("60 ㎡");
//        item.setImgs(
//                Arrays.asList(
//                        "group1/M00/00/00/CtM3B2O2_M2APJA3AAuC467ZRns137.png",
//                        "group1/M00/00/00/CtM3B2O2_OeARTnEABS0Lvm4RSc779.png",
//                        "group1/M00/00/00/CtM3B2O2_QWAQuL4ABHVENCjbfU648.png"
//                )
//        );
//        item.setPrice(3000L);
//        item.setRecommendation(true);
//        item.setRecoSort((byte) 9);
//        item.setRentType("整租");
//        item.setSales(300L);
//        info = new HashMap<>();
//        info.put("years", "2000");
//        info.put("type", "2室1厅");
//        info.put("level", "6/6层");
//        info.put("style", "简单装修");
//        info.put("orientation", "朝南");
//        item.setInfo(info);
//        item.setTitle("北京老小区");
//        items.add(item);
//
//        item = new Item();
//        item.setCity("上海");
//        item.setHouseType("150 ㎡");
//        item.setImgs(
//                Arrays.asList(
//                        "group1/M00/00/00/CtM3B2O2_DuAW02hABLGy4zg5nA326.png",
//                        "group1/M00/00/00/CtM3B2O2_JGAdNoSAAjIobLVxBY563.png",
//                        "group1/M00/00/00/CtM3B2O2_LOAG7vvAAro9yfjOVw343.png"
//                )
//        );
//        item.setPrice(12000L);
//        item.setRecommendation(true);
//        item.setRecoSort((byte) 9);
//        item.setRentType("整租");
//        item.setSales(100L);
//        item.setTitle("上海高档公寓");
//        info = new HashMap<>();
//        info.put("years", "2010");
//        info.put("type", "3室2厅");
//        info.put("level", "10/18层");
//        info.put("style", "精装修");
//        info.put("orientation", "南北通透");
//        item.setInfo(info);
//        items.add(item);
//
//        item = new Item();
//        item.setCity("上海");
//        item.setHouseType("230 ㎡");
//        item.setImgs(
//                Arrays.asList(
//                        "group1/M00/00/00/CtM3B2O2_M2APJA3AAuC467ZRns137.png",
//                        "group1/M00/00/00/CtM3B2O2_OeARTnEABS0Lvm4RSc779.png",
//                        "group1/M00/00/00/CtM3B2O2_QWAQuL4ABHVENCjbfU648.png"
//                )
//        );
//        item.setPrice(21000L);
//        item.setRecommendation(true);
//        item.setRecoSort((byte) 12);
//        item.setRentType("整租");
//        item.setSales(30L);
//        info = new HashMap<>();
//        info.put("years", "2007");
//        info.put("type", "5室3厅");
//        info.put("level", "2/2层");
//        info.put("style", "精装修");
//        info.put("orientation", "南北通透");
//        item.setInfo(info);
//        item.setTitle("上海联排别墅");
//        items.add(item);
//
//        item = new Item();
//        item.setCity("上海");
//        item.setHouseType("310 ㎡");
//        item.setImgs(
//                Arrays.asList(
//                        "group1/M00/00/00/CtM3B2O2_DuAW02hABLGy4zg5nA326.png",
//                        "group1/M00/00/00/CtM3B2O2_JGAdNoSAAjIobLVxBY563.png",
//                        "group1/M00/00/00/CtM3B2O2_LOAG7vvAAro9yfjOVw343.png"
//                )
//        );
//        item.setPrice(30000L);
//        item.setRecommendation(true);
//        item.setRecoSort((byte) 6);
//        item.setRentType("整租");
//        item.setSales(10L);
//        info = new HashMap<>();
//        info.put("years", "2013");
//        info.put("type", "6室4厅");
//        info.put("level", "3/3层");
//        info.put("style", "豪华装修");
//        info.put("orientation", "四面环海");
//        item.setInfo(info);
//        item.setTitle("上海独栋别墅");
//        items.add(item);
//
//        item = new Item();
//        item.setCity("上海");
//        item.setHouseType("60 ㎡");
//        item.setImgs(
//                Arrays.asList(
//                        "group1/M00/00/00/CtM3B2O2_M2APJA3AAuC467ZRns137.png",
//                        "group1/M00/00/00/CtM3B2O2_OeARTnEABS0Lvm4RSc779.png",
//                        "group1/M00/00/00/CtM3B2O2_QWAQuL4ABHVENCjbfU648.png"
//                )
//        );
//        item.setPrice(3000L);
//        item.setRecommendation(true);
//        item.setRecoSort((byte) 9);
//        item.setRentType("整租");
//        item.setSales(300L);
//        info = new HashMap<>();
//        info.put("years", "2000");
//        info.put("type", "2室1厅");
//        info.put("level", "6/6层");
//        info.put("style", "简单装修");
//        info.put("orientation", "朝南");
//        item.setInfo(info);
//        item.setTitle("上海老小区");
//        items.add(item);
//
//        mongoTemplate.insert(items, Item.class);
//    }
//
//
//        //@Test
////    public void insertBanner() {
////        List<Banner> list = new ArrayList<Banner>();
//////        Banner banner = new Banner();
//////        banner.setCreateTime(new Date());
//////        banner.setUrl("group1/M00/00/00/CtM3B2O2_DuAW02hABLGy4zg5nA326.png");
//////        list.add(banner);
////
////        Banner banner2 = new Banner();
////        banner2.setCreateTime(new Date());
////        banner2.setUrl("group1/M00/00/00/CtM3B2O2_JGAdNoSAAjIobLVxBY563.png");
////        list.add(banner2);
////
////        Banner banner3 = new Banner();
////        banner3.setCreateTime(new Date());
////        banner3.setUrl("group1/M00/00/00/CtM3B2O2_LOAG7vvAAro9yfjOVw343.png");
////        list.add(banner3);
////
////        Banner banner4 = new Banner();
////        banner4.setCreateTime(new Date());
////        banner4.setUrl("group1/M00/00/00/CtM3B2O2_M2APJA3AAuC467ZRns137.png");
////        list.add(banner4);
////
////        Banner banner5 = new Banner();
////        banner5.setCreateTime(new Date());
////        banner5.setUrl("group1/M00/00/00/CtM3B2O2_OeARTnEABS0Lvm4RSc779.png");
////        list.add(banner5);
////
////        Banner banner6 = new Banner();
////        banner6.setCreateTime(new Date());
////        banner6.setUrl("group1/M00/00/00/CtM3B2O2_QWAQuL4ABHVENCjbfU648.png");
////        list.add(banner6);
////        mongoTemplate.insert(list, Banner.class);
////
////    }
//
//    }
