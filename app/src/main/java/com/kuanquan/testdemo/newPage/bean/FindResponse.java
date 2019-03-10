package com.kuanquan.testdemo.newPage.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class FindResponse implements Serializable {
    public int http_code  ;
    public int status  ;
    public String info  ;
    public List<Result> result;
    public class Result implements Serializable  {
        public int article_id  ;   // 文章id
        public int comment_num  ;  // 阅读数
        public int like_num  ;    // 点赞数
        public int dede_aid  ;
        public String arcurl  ;    // 链接
        public String share_url  ; // 分享链接
        public String column_name  ;
        public String description  ;  // 内容
        public String litpic  ;    // 图片
        public int click_num  ;  // 点击次数
        public String time  ;   // 时间
        public String title  ;  // 标题
    }
}
