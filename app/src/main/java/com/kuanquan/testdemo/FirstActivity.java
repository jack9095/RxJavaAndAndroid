package com.kuanquan.testdemo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class FirstActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_a);
		EventBus.getDefault().register(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
	
	public void onClick(View v){
//    	EventBus.getDefault().postSticky(new EventCenter<>(EventType.ONE));
		EventBus.getDefault().post(new EventCenter<>(EventType.ONE));
    }
	
	@Subscribe(threadMode = ThreadMode.POSTING,sticky = false,priority = 1)
	public void onEventThreadActivity(EventCenter<?> eventCenter){
		switch (eventCenter.getEventType()) {
		case EventType.ONE:
			Log.e("FirstActivity", eventCenter.getEventType() + "***********");
			break;

		default:
			break;
		}
	}
	
}
