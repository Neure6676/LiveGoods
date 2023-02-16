package com.livegoods.search.dao.impl;

import com.livegoods.search.dao.ItemDao4ES;
import com.livegoods.search.pojo.Item4ES;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class ItemDao4ESImpl implements ItemDao4ES {
    @Autowired
    private ElasticsearchRestTemplate restTemplate;
    @Value("${livegoods.search.init.enabled}")
    private boolean initEnabled = false;

    /**
     * 分页搜索， 高亮处理。
     * @param city 城市
     * @param content 搜索关键字， 在title商品标题字段中匹配。
     * @param page 页码， 从0开始的
     * @param rows 查询行数
     * @return
     */
    @Override
    public AggregatedPage<Item4ES> queryForPage(String city, String content, int page, int rows) {
        // 高亮设置
        HighlightBuilder.Field field = new HighlightBuilder.Field("title");
        field.preTags("<span style='color:red'>");
        field.postTags("</span>");

        // 搜索条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 获取必要搜索条件集合
        List<QueryBuilder> mustList = boolQueryBuilder.must();
        mustList.add(
                QueryBuilders.matchQuery("city", city)
        );
        // 获取可选搜索条件集合
        List<QueryBuilder> shouldList = boolQueryBuilder.should();
        shouldList.add(
                QueryBuilders.matchQuery("title", content) // 标题搜索
        );
        shouldList.add(
                QueryBuilders.matchQuery("houseType", content) // 房屋类型搜索
        );
        shouldList.add(
                QueryBuilders.matchQuery("rentType", content) // 租赁方式搜索
        );

        // 搜索条件创建
        SearchQuery query =
                new NativeSearchQueryBuilder()
                        .withQuery(boolQueryBuilder) // 搜索条件
                        .withHighlightFields(field) // 高亮
                        .withPageable(
                                PageRequest.of(page, rows) // 分页
                        )
                        .build();

        // 搜索
        AggregatedPage<Item4ES> resultPage = restTemplate.queryForPage(query, Item4ES.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                // 处理后的结果集合
                List<T> resultList = new ArrayList<>();
                // 获取搜索结果
                SearchHit[] searchHits = response.getHits().getHits();
                for(SearchHit searchHit : searchHits){
                    // 搜索的结果对象
                    Map<String, Object> objectMap = searchHit.getSourceAsMap();
                    Item4ES item4ES = new Item4ES();

                    // 数据的处理
                    item4ES.setId(objectMap.get("id").toString());
                    item4ES.setRentType(objectMap.get("rentType").toString());
                    item4ES.setPrice(objectMap.get("price").toString());
                    item4ES.setImg(objectMap.get("img").toString());
                    item4ES.setHouseType(objectMap.get("houseType").toString());
                    item4ES.setCity(objectMap.get("city").toString());

                    // 处理高亮
                    Map<String, HighlightField> highlightFieldMap = searchHit.getHighlightFields();
                    if(highlightFieldMap.containsKey("title")){
                        // 高亮数据有title
                        item4ES.setTitle(highlightFieldMap.get("title").getFragments()[0].toString());
                    }else {
                        // 没有高亮数据
                        item4ES.setTitle(objectMap.get("title").toString());
                    }

                    resultList.add((T) item4ES);
                }
                return new AggregatedPageImpl(resultList, // 搜索结果集合
                        pageable, // 分页辅助对象
                        response.getHits().getTotalHits(), // 总计多少行数据， 常规返回时，前三个构造参数就足够了
                        response.getAggregations(), // 聚合对象
                        response.getScrollId(), // 窗口搜索主键
                        response.getHits().getMaxScore()); // 搜索结果的最大分数。
            }

            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> type) {
                return null;
            }
        });

        return resultPage;
    }

    @Override
    public void batchIndex(List<Item4ES> items) {
        // 判断是否需要创建索引和设置映射。
        if(initEnabled){
            this.createIndex();
            this.putMapping();
        }
        List<IndexQuery> queryList = new ArrayList<>();
        for(Item4ES item : items){
            queryList.add(new IndexQueryBuilder().withObject(item).build());
        }
        // 批量新增
        restTemplate.bulkIndex(queryList);
    }

    @Override
    public void index(Item4ES item) {
        this.batchIndex(Arrays.asList(item));
    }

    // 创建索引
    private void createIndex(){
        restTemplate.createIndex(Item4ES.class);
    }

    // 定义索引的映射
    private void putMapping(){
        restTemplate.putMapping(Item4ES.class);
    }
}

