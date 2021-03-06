package com.yue.Spider.douban;


import com.yue.Spider.douban.model.CrawlItem;
import com.yue.Spider.douban.model.DoubanComment;
import org.apache.commons.logging.*;
import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: abekwok
 * Create: 9/18/14
 */
public class DoubanCommentCrawlerMap implements FlatMapFunction<CrawlItem, DoubanComment> {
    private static final long serialVersionUID = -3986244606585552569L;
    private static Log LOG = LogFactory.getLog(DoubanCommentCrawlerMap.class);
    private static DoubanCrawler crawler;
    public Iterable<DoubanComment> call(CrawlItem crawlItem) throws Exception {
        if(crawler==null){
            crawler = new DoubanCrawler();
        }
        System.out.println("call: " + crawlItem);
        System.out.println();

        List<DoubanComment> comments = crawler.getComments(crawlItem);

        if(comments == null){
            comments = new ArrayList<DoubanComment>();
        }
        return comments;
    }
}
