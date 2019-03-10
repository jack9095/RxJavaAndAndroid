package com.kuanquan.testdemo.newPage.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
public class ArticleListResponse implements Serializable {

    public int http_code;
    public int status;    // 0 成功
    public String info;
    public Result result;

    public class Result implements Serializable {
        public String totalCount;
        public List<Article> list;
    }

    public class Article implements Serializable {

        public String Title;  //类型：String  必有字段  备注：标题
        public String ColumnName;//类型：String  必有字段  备注：栏目名称
        public int Click;     //类型：Number  必有字段  备注：浏览数
        public String Litpic;    //类型：String  必有字段  备注：封面图
        public int ArticleId;//类型：Number  必有字段  备注：文章id（非dede文章id）
        public int Atype;//类型：Number  必有字段  备注：文章内容类型（0为文本，1为视频，2为音频）
        public String AtypeTime;//类型：Number  必有字段  备注：文章内容类型时长（秒）

    }
}
