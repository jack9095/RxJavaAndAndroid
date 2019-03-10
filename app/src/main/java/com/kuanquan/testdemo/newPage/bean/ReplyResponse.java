package com.kuanquan.testdemo.newPage.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class ReplyResponse implements Serializable {
    public int http_code  ;
    public int status  ;
    public String info  ;
    public  Result result;
    public class Result implements Serializable  {
        public String totalCount  ;
        public List<Ab> list;
        public class Ab implements Serializable  {
            public int ParentId  ;
            public String Content  ;  // 回复内容
            public int IsFirst  ;     // 是否是第一个
            public int Student_id  ;
            public int IsLiked  ;      // 是否点赞
            public String Time  ;
            public int Liked_num  ;    // 喜欢（点赞）个数
            public int Pid  ;
            public int Aid  ;
            public String Avatar  ;    // 头像
            public String Nickname  ;  // 昵称
        }
    }
}
