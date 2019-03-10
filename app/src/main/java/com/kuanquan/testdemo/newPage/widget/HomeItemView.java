//package com.kuanquan.testdemo.newPage.widget;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.os.Build;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.example.administrator.myapplication.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by fei.wang on 2018/7/6.
// */
//public class HomeItemView extends FrameLayout {
//
//    private TextView tvOne, tvTwo, tvThree, tvFour, tvFive;
//    private RelativeLayout rlOne, rlTwo, rlThree, rlFour, rlFive;
//    private ImageView ivOne, ivTwo, ivThree, ivFour, ivFive;
//
//    public List<View> views = new ArrayList<>();
//    public List<View> viewOnes = new ArrayList<>();
//    public List<TextView> textViews = new ArrayList<>();
//    public List<ImageView> imageViews = new ArrayList<>();
//    public List<ImageView> imageViewOnes = new ArrayList<>();
//
//    public HomeItemView(@NonNull Context context) {
//        super(context);
//        init();
//    }
//
//    public HomeItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public HomeItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }
//
//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public HomeItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        init();
//    }
//
//    public void init() {
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.home_item_layout, this, true);
//        tvOne = (TextView) view.findViewById(R.id.elective_course_text);
//        tvTwo = (TextView) view.findViewById(R.id.live_text);
//        tvThree = (TextView) view.findViewById(R.id.bank_text);
//        tvFour = (TextView) view.findViewById(R.id.answer_text);
//        tvFive = (TextView) view.findViewById(R.id.member_text);
//        textViews.add(tvOne);
//        textViews.add(tvTwo);
//        textViews.add(tvThree);
//        textViews.add(tvFour);
//        textViews.add(tvFive);
//
//        rlOne = (RelativeLayout) view.findViewById(R.id.course_item);
//        rlTwo = (RelativeLayout) view.findViewById(R.id.live_item);
//        rlThree = (RelativeLayout) view.findViewById(R.id.bank_item);
//        rlFour = (RelativeLayout) view.findViewById(R.id.answer_item);
//        rlFive = (RelativeLayout) view.findViewById(R.id.member_item);
//        views.add(rlOne);
//        views.add(rlTwo);
//        views.add(rlThree);
//        views.add(rlFour);
//        views.add(rlFive);
//
//        ivOne = (ImageView) view.findViewById(R.id.elective_course_image);
//        ivTwo = (ImageView) view.findViewById(R.id.live_image);
//        ivThree = (ImageView) view.findViewById(R.id.bank_image);
//        ivFour = (ImageView) view.findViewById(R.id.answer_image);
//        ivFive = (ImageView) view.findViewById(R.id.member_image);
//        imageViews.add(ivOne);
//        imageViews.add(ivTwo);
//        imageViews.add(ivThree);
//        imageViews.add(ivFour);
//        imageViews.add(ivFive);
//
//    }
//
//    public void setOnClick(OnClickListener listener) {
//        rlOne.setOnClickListener(listener);
//        rlTwo.setOnClickListener(listener);
//        rlThree.setOnClickListener(listener);
//        rlFour.setOnClickListener(listener);
//        rlFive.setOnClickListener(listener);
//    }
//
//}
