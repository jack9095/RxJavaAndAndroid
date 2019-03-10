//package com.kuanquan.testdemo.newPage;
//
//import android.animation.LayoutTransition;
//import android.animation.ObjectAnimator;
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.AppBarLayout;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.kuanquan.testdemo.R;
//import com.kuanquan.testdemo.newPage.adapter.HomeAdapter;
//import com.kuanquan.testdemo.newPage.bean.DataUtils;
//import com.kuanquan.testdemo.newPage.bean.HomeBeanChild;
//import com.kuanquan.testdemo.newPage.bean.HomeData;
//import com.kuanquan.testdemo.newPage.widget.AnimatorUtil;
//import com.kuanquan.testdemo.newPage.widget.GlideUtil;
//import com.kuanquan.testdemo.newPage.widget.HomeBanner;
//import com.kuanquan.testdemo.newPage.widget.HomeItemView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity implements HomeAdapter.OnHomeListener, HomeBanner.OnPageClickListener,View.OnClickListener{
//    private HomeBanner mHomeBanner;
//    private HomeAdapter mHomeAdapter;
//    private RecyclerView mRecyclerView;
//    private SwipeRefreshLayout mSwipeRefreshLayout;
//    private RelativeLayout headerView;
//    private TextView headerTv, moreTv;
//    private TextView mTextView;
//    private String userId;
//    private HomeItemView mHomeItemView,mHomeItemViewOne;
//    private List<HomeData> lists = new ArrayList<>();
//    private HomeData mHomeData;
//
//    ImageView live_open_head_image;
//    TextView live_open_title, live_open_content;
//    RelativeLayout liveRelativeLayout;
//    RelativeLayout open_live_root;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        onInit();
//    }
//
//    protected void initData() {
//        mHomeAdapter = new HomeAdapter(this);
//        mRecyclerView.setAdapter(mHomeAdapter);
//        mHomeAdapter.setData(DataUtils.getFindData());
//        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                lists.clear();
//            }
//        });
//
//        /*mRecyclerView.setOnBottomCallback(new MyRecyclerView.OnBottomCallback() {
//            @Override
//            public void onBottom() {
//
//            }
//        });*/
//        String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528784678961&di=3d8861c62ef509d7eecf123b99c74dad&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fdcc451da81cb39dbd7c13dcbda160924ab18302d.jpg";
//
//        GlideUtil.setImageCircle(this, imageUrl, live_open_head_image);
//        live_open_title.setText("《经济学动态》是中国社会科学院经济研究所主办的向国内外发行的经济类月刊");
//        live_open_content.setText("主要栏目与内容包括：经济科学新论、经济热点分析、部门经济、地区经济、财政金融研究");
//    }
//
//    @Override
//    public void onNotify(int type) {
//        AnimatorUtil.setHideShow(mTextView,type);
//    }
//
//    @Override
//    public void goLive() {
//        Toast.makeText(this,"去直播",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void goLiveDetail(HomeData homeBean) {
//        Toast.makeText(this,"去直播详情",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void goSetPreference() {
//        Toast.makeText(this,"去设置偏好",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void goFindDetail(HomeData homeBean,int position) {
////        Intent intent = new Intent(this,DetailsArticleActivity.class);
////        intent.putExtra("article_id",homeBean.id);
////        intent.putExtra("position_f",position);
////        startActivityForResult(intent, 8);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == 2) {
//            if (requestCode == 8) {
//                int position_f = data.getIntExtra("position_f", 0);
//                HomeData homeData = lists.get(position_f);
//                homeData.click_num++;
//                mHomeAdapter.notifyDataSetChanged();
//            }
//        }
//    }
//
//    @Override
//    public void onPageClick(HomeBeanChild info) {  // banner 点击回调
//        switch (info.action){
//            case "LIVE_DESCRIPTION": // 直播
//                break;
//            case "COURSE_DESCRIPTION": // 课程
//                break;
//            default:
//                if (TextUtils.equals("H5",info.action_type)) {  // h5
//
//                }
//                break;
//        }
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.course_item:  // 选课
//                Toast.makeText(this,"选课",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.live_item:    // 直播
//                Toast.makeText(this,"直播",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.bank_item:    // 题库
//                Toast.makeText(this,"题库",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.answer_item:  // 活动
//                Toast.makeText(this,"活动",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.member_item:
//                break;
//        }
//    }
//
//    public void onInit() {
//        mRecyclerView = (RecyclerView) findViewById(R.id.notify_recyclerView);
//        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.notify_swipeRefreshLayout);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
////        mRecyclerView.addOnScrollListener(new RvScrollListener());
//        mHomeBanner = (HomeBanner) findViewById(R.id.home_banner_layout);
//        mHomeBanner.setData(DataUtils.getBannerData(), this);
//        mHomeBanner.setScrollSpeed(mHomeBanner);
//        headerView = (RelativeLayout) findViewById(R.id.stick_rl_adapter);
//        moreTv = (TextView) findViewById(R.id.text_live_more_open);
//        headerTv = (TextView) findViewById(R.id.text_live_open);
//        headerTv.setText("发现");
//        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.home_appbar);
//        mHomeItemView = (HomeItemView) findViewById(R.id.home_item_view);
//        mHomeItemViewOne = (HomeItemView) findViewById(R.id.home_item_view_suspension);
//        initAppBarLayout(mAppBarLayout,mHomeItemViewOne);
//        mTextView = (TextView) findViewById(R.id.home_im_text);
////        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout_stick);
////        mFrameLayout.setVisibility(View.GONE);
//        mHomeItemView.setOnClick(this);
//        mHomeItemViewOne.setOnClick(this);
//
//        live_open_head_image = (ImageView) findViewById(R.id.live_open_head_image);
//        live_open_title = (TextView) findViewById(R.id.live_open_title);
//        live_open_content = (TextView) findViewById(R.id.live_open_content);
//        liveRelativeLayout = (RelativeLayout) findViewById(R.id.layout_f_rl_right);
//        open_live_root = (RelativeLayout) findViewById(R.id.open_live_root);
//
//        initData();
//    }
//
//
//    protected void initAppBarLayout(AppBarLayout mAppBarLayout, final HomeItemView notify_stick_rl_suspension) {
//        LayoutTransition mTransition = new LayoutTransition();
//        ObjectAnimator addAnimator = ObjectAnimator.ofFloat(null, "translationY", 0, 1.f).
//                setDuration(mTransition.getDuration(LayoutTransition.APPEARING));
//        mTransition.setAnimator(LayoutTransition.APPEARING, addAnimator);
//        final int headerHeight = getResources().getDimensionPixelOffset(R.dimen.header_home_height);
//        mAppBarLayout.setLayoutTransition(mTransition);
//
//        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                verticalOffset = Math.abs(verticalOffset);
//                if (verticalOffset >= headerHeight) {
//                    if (notify_stick_rl_suspension.getVisibility() == View.GONE) {
//                        notify_stick_rl_suspension.setVisibility(View.VISIBLE);
//                    }
//                } else if (verticalOffset > 8) {
//                    if (notify_stick_rl_suspension.getVisibility() == View.VISIBLE) {
//                        notify_stick_rl_suspension.setVisibility(View.GONE);
//                    }
//                }
//            }
//        });
//    }
//}
