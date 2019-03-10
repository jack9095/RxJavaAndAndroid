package com.kuanquan.testdemo.newPage.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

/**
 * Created by fei.wang on 2018/7/6.
 */

public class AnimatorUtil {

    public static void setHideShow(final TextView mTextView, int type) {
        if (1 == type) {
            mTextView.setText("将减少为您推送此类咨询");
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTextView, "y", -82.0f, 0.0f);
        objectAnimator.setDuration(500);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mTextView.clearAnimation();
            }
        });
        objectAnimator.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTextView, "y", 0.0f, -122.0f);
                objectAnimator.setDuration(500);
                objectAnimator.setRepeatCount(0);
                objectAnimator.setInterpolator(new LinearInterpolator());
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mTextView.clearAnimation();
                    }
                });
                objectAnimator.start();
            }
        }, 3000);
    }
}
