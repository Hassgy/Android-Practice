package com.example.hassgy.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import com.example.hassgy.R;
import com.example.hassgy.ui.base.BaseActivity;
import com.example.hassgy.ui.view.MovieDetailsView;
import com.ulfy.android.system.ActivityUtils;
import com.ulfy.android.system.AppUtils;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.ulfy.android.ui_injection.ViewClick;

@Layout(id = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @ViewClick(ids = R.id.detailPageBtn) private void gotoDetailPage(View view) {
        ActivityUtils.startActivity(SplashActivity.class);
        finish();
    }

    @Override public void onBackPressed() {
        AppUtils.exitTwice("再按一次退出" + AppUtils.getAppName());
    }
}