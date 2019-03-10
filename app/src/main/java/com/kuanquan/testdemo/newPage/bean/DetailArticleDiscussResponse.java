package com.kuanquan.testdemo.newPage.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 *
 */
public class DetailArticleDiscussResponse implements Serializable {
    public int http_code  ;
    public int status  ;    // 0 成功
    public String info  ;
    public  Result result;
    public class Result implements Serializable  {
        public String totalCount  ;
        public List<Aa> list;
        public class Aa implements Serializable  {
            public String Content  ;  // 评论内容
            public int Student_id  ;
            public int IsLiked  ;     // 0是没点赞  其它是点赞
            public String Time  ;    // 时间
            public int Liked_num  ;
            public int Pid  ;
            public int Reply_num  ;     // 回复数
            public String Avatar  ;     // 头像
            public String Nickname  ;   // 昵称
        }
    }
}
