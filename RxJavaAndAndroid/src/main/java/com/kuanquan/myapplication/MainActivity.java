package com.kuanquan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建被观察者对象
        Observable observable = Observable.create(new ObservableOnSubscribe(){

            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {

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
        observable.subscribe(observer);
    }
}