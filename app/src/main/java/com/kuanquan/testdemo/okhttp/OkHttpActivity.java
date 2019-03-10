package com.kuanquan.testdemo.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kuanquan.testdemo.R;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 整个网络请求可以看成一个一个拦截器执行chain.proceed的过程
 */
public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
    }

    // Okhttp 中使用的缓存cache其实最后还是使用的 DiskLruCache,通过Okhttp内部的线程池对缓存进行保存清除等操作的
    // 不缓存get方法的响应
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .cache(new Cache(new File("cache"),24*1024*1024))
            .readTimeout(5, TimeUnit.SECONDS).build();

    public void onClick(View view) {
        Request request = new Request.Builder()
                .url("http://www.baidu.com").get().build();
        Call call = okHttpClient.newCall(request); // 实际的Http请求，可以当做request和response连接的桥梁
        try {
            Response response = call.execute(); // 执行同步请求
            System.out.println(response.body().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        call.enqueue(new Callback() { // 执行异步请求回调
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
