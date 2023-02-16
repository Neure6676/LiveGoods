package com.livegoods.search.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * ElasticSearch访问过程中使用的实体类型。
 * Spring Data Elasticsearch中使用的实体
 * 必须提供若干注解描述
 */
@Document(indexName = "livegoods-item", type = "item")
@Data
@NoArgsConstructor
public class Item4ES {
    @Id
    private String id;
    // 租赁方式, 不分词
    @Field(type = FieldType.Keyword)
    private String rentType;
    // 价格， <h3>价格</h3>， 不分词
    @Field(type = FieldType.Keyword)
    private String price;
    // 房屋类型
    @Field(type = FieldType.Keyword)
    private String houseType;
    // 图片地址
    @Field(type = FieldType.Keyword)
    private String img;
    // 商品标题
    @Field(type = FieldType.Keyword)
    private String title;
    // 城市
    @Field(type = FieldType.Keyword)
    private String city;
}

