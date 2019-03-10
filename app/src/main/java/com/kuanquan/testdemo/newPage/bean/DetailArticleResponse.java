package com.kuanquan.testdemo.newPage.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/3.
 *
 */
public class DetailArticleResponse implements Serializable {
    public int http_code  ;
    public int status  ;
    public String info  ;
    public  Result result;
    public class Result implements Serializable  {
        public int article_id  ;    // 文章id
        public int comment_num  ;   // 文章下的评论数
        public int like_num  ;      // 点赞量
        public int is_favorite  ;   // 该学员是否收藏 1 收藏 0 没收藏
        public int dede_aid  ;      // dede文章id
        public String arcurl  ;     // 文章内容html地址
        public String column_name  ; // 栏目名称
        public String litpic  ;        // 分享 封面图片
        public int click_num  ;    // 浏览量
        public int is_liked  ;     // 该学员是否点赞
        public String description  ;     // 分享内容
        public String share_url  ;     // 分享链接
        public String title  ;     // 分享（标题）
    }
}
