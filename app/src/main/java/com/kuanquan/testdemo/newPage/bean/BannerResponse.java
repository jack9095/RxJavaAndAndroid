package com.kuanquan.testdemo.newPage.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fei.wang on 2018/7/5.
 */
public class BannerResponse implements Serializable {
    public int http_code  ;
    public int status  ;
    public String info  ;
    public  Result result;
    public class Result implements Serializable  {
        public List<AdvList> advList;
        public class AdvList implements Serializable  {
            public String ext  ;
            public String image  ;   // banner 图片
            public String action_type  ;  // 跳转类型 native h5 weex
            public String action  ;
            public Params params;
            public class Params implements Serializable  {
                public String liveId  ;
                public String courseId  ;
            }
        }
        public List<Menu> menu;
        public class Menu implements Serializable  {
            public String ext  ;
            public String action_type  ;  // 跳转类型  native  h5  weex
            public String icon  ;        // 图标
            public String action  ;     // 具体是哪个item  （COURSE_CENTER、LIVE、QUESTION、）
            public String title  ;     // 标题
        }
        public  OpenLive openLive;
        public class OpenLive implements Serializable  {
            public String ext  ;
            public String action_type  ;
            public String action  ;
            public  Params params;
            public class Params implements Serializable  {
                public String description  ;
                public String title  ;
                public String liveId  ;
                public String teacherAvatar  ;
            }
        }
    }
}
