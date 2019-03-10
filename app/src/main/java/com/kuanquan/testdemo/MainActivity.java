package com.kuanquan.testdemo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 配置完成后重新Rebuild Project项目，
 * 然后我们到\app\build\generated\source\apt\debug\package\查看是否生成所配置的的文件EventBusIndex
 */
public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a);
        EventBus.getDefault().postSticky(new EventCenter<>(EventType.ONE));
        EventBus.getDefault().post(new EventCenter<>(EventType.ONE));
//        EventBus.getDefault().register(this);
        EventBus mEventBus = EventBus.getDefault();
        EventBus eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
        eventBus.register(this);

        // 创建被观察者对象
        Observable observable = Observable.create(new ObservableOnSubscribe(){

            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                e.onNext("hello");
                e.onNext("world");
                e.onComplete();
            }
        });

        // 创建观察者
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,Thread.currentThread().getName());
                Log.e(TAG,"******** onSubscribe ********");
                System.out.println();
                System.out.println();
            }

            @Override
            public void onNext(Object o) {
                Log.e(TAG,Thread.currentThread().getName());
                Log.e(TAG,"******** onNext ********");
                System.out.println();
                System.out.println();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,Thread.currentThread().getName());
                Log.e(TAG,"******** onError ********");
                System.out.println();
                System.out.println();
            }

            @Override
            public void onComplete() {
                Log.e(TAG,Thread.currentThread().getName());
                Log.e(TAG,"******** onComplete ********");
                System.out.println();
                System.out.println();
            }
        };

        // 被观察者订阅给观察者
        observable.observeOn(Schedulers.io())
                .subscribe(observer);
    }
    
    public void onClick(View v){
    	startActivity(new Intent(this,FirstActivity.class));
        eventBus.postSticky(new EventCenter<Object>(EventType.ONE));
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
//    	EventBus.getDefault().unregister(this);
        eventBus.unregister(this);
    }
    
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = false,priority = 4)
    public void onEventThread(EventCenter eventCenter){
    	switch (eventCenter.getEventType()) {
		case EventType.ONE:
			Log.e("MainActivity", eventCenter.getEventType());
			break;

		default:
			break;
		}
    	EventBus.getDefault().cancelEventDelivery(eventCenter);
    }
}
