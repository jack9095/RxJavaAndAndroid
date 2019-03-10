package com.kuanquan.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kuanquan.databinding.bean.User;
import com.kuanquan.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        // 通过下面的方式就完成了User和View的绑定
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        User user = new User("Test","User");
        binding.setUser(user);

        // 也可以通过下述方式获取整个layout的View
//        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        // 如果你是在ListView 或者RecycleView的Adapter中bind Item，你可以通过如下方式获取
//        ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
        // 或者
//        ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);
    }
}
