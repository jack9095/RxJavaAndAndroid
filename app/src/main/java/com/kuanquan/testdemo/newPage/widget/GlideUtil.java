package com.kuanquan.testdemo.newPage.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;

/**
 * Gilde管理类
 */
public class GlideUtil {

    static class BaseTransformation implements Transformation {

        @Override
        public Resource transform(Resource resource, int outWidth, int outHeight) {
            return resource;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }

    public static void setImage(Context context, String imageUrl, ImageView view){
        if (!TextUtils.isEmpty(imageUrl)) {

            if (!imageUrl.startsWith("http:") && !imageUrl.startsWith("https:")) {
                imageUrl = "http:" + imageUrl;
            }

            if (imageUrl.endsWith("gif")) {
                Glide.with(context)
                        .load(imageUrl)
                        .asGif()
//                        .placeholder(R.drawable.news_img_default)
//                        .error(R.drawable.news_img_default)
                        .into(view);
            } else {
                Glide.with(context)
                        .load(imageUrl)
                        .asBitmap()
                        .centerCrop()
//                        .placeholder(R.drawable.news_img_default)
//                        .error(R.drawable.news_img_default)
                        .transform(new GlideRoundTransform(context))
                        .into(view);
            }
        } else {
//            Glide.with(context)
////                    .load(R.drawable.news_img_default)
//                    .asBitmap()
//                    .transform(new GlideRoundTransform(context))
//                    .into(view);
        }
    }

    public static void setImageUrl(Context context, String imageUrl, ImageView view) {
        if (!TextUtils.isEmpty(imageUrl)) {

            if (!imageUrl.startsWith("http:") && !imageUrl.startsWith("https:")) {
                imageUrl = "http:" + imageUrl;
            }

            if (imageUrl.endsWith("gif")) {
                Glide.with(context)
                        .load(imageUrl)
                        .asGif()
//                        .placeholder(R.drawable.news_img_default)
//                        .error(R.drawable.news_img_default)
                        .into(view);
            } else {
                Glide.with(context)
                        .load(imageUrl)
                        .asBitmap()
//                        .placeholder(R.drawable.news_img_default)
//                        .error(R.drawable.news_img_default)
                        .into(view);
            }
        } else {
//            Glide.with(context)
//                    .load(R.drawable.news_img_default)
//                    .asBitmap()
//                    .into(view);
        }
    }

    public static void setImageCircle(Context context, String imageUrl, ImageView view) {
        if (!TextUtils.isEmpty(imageUrl)) {

            if (!imageUrl.startsWith("http:") && !imageUrl.startsWith("https:")) {
                imageUrl = "http:" + imageUrl;
            }

            Glide.with(context)
                    .load(imageUrl)
                    .asBitmap()
//                    .placeholder(R.drawable.news_img_default)
//                    .error(R.drawable.news_img_default)
                    .transform(new GlideCircleTransform(context))
                    .into(view);
        } else {
//            Glide.with(context)
//                    .load(R.drawable.news_img_default)
//                    .asBitmap()
//                    .transform(new GlideCircleTransform(context))
//                    .into(view);
        }
    }

    public static void loadPicture(Context context, String url, ImageView imageView) {
        if(!url.startsWith("http:") && !url.startsWith("https:")){
            url = "http:"+url;
        }
        if (!TextUtils.isEmpty(url) && url.contains(".gif")) {
            Glide.with(context.getApplicationContext())
                    .load(url)
//                    .placeholder(R.drawable.news_img_default)
//                    .error(R.drawable.news_img_default)
                    .centerCrop()
                    .into(imageView);
        } else {
            Glide.with(context.getApplicationContext())
                    .load(url)
                    .asBitmap()
//                    .placeholder(R.drawable.news_img_default)
//                    .error(R.drawable.news_img_default)
                    .into(imageView);
        }
    }
}
