//package com.example.hassgy.ui.activity;
//
//import android.os.Bundle;
//import android.support.design.widget.TabLayout;
//import android.support.v4.view.ViewPager;
//import android.view.View;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.ulfy.android.system.ActivityUtils;
//import com.ulfy.android.ui_injection.Layout;
//import com.ulfy.android.ui_injection.ViewById;
//import com.example.hassgy.R;
//import com.example.hassgy.ui.base.BaseActivity;
//import com.ulfy.android.ui_injection.ViewClick;
//import com.ulfy.android.utils.StatusBarUtils;
//
//import java.util.ArrayList;
//
//@Layout(id = R.layout.activity_guide)
//public class GuideActivity extends BaseActivity {
//    @ViewById(id = R.id.xbanner) private XBanner xBanner;
//    @ViewById(id = R.id.btn) private Button btn;
//
//    public static void startActivity() {
//        ActivityUtils.startActivity(GuideActivity.class);
//    }
//
//    @Override protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        StatusBarUtils.visiable(this, false);
//        initViewContent();
//    }
//
//    public void initViewContent() {
//        List<LocalImageInfo> localImageInfoList = new ArrayList<>();
//        localImageInfoList.add(new LocalImageInfo(R.drawable.welcom1));
//        localImageInfoList.add(new LocalImageInfo(R.drawable.welcom2));
//        localImageInfoList.add(new LocalImageInfo(R.drawable.welcom3));
//        localImageInfoList.add(new LocalImageInfo(R.drawable.welcom4));
//        localImageInfoList.add(new LocalImageInfo(R.drawable.welcom5));
//        xBanner.setBannerData(localImageInfoList);
//        xBanner.loadImage(new XBanner.XBannerAdapter() {
//            @Override public void loadBanner(XBanner banner, Object model, View view, int position) {
//                ((ImageView) view).setImageResource(((LocalImageInfo) model).getXBannerUrl());
//            }
//        });
//        xBanner.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if (position == xBanner.getRealCount() - 1) {
//                    btn.setVisibility(View.VISIBLE);
//                } else {
//                    btn.setVisibility(View.GONE);
//                }
//            }
//        });
//    }
//
//    @ViewClick(ids = R.id.btn) private void enterApp(View view) {
//        ActivityUtils.startActivity(MainActivity.class);
//        finish();
//    }
//}