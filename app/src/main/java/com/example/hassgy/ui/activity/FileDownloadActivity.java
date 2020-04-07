package com.example.hassgy.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ulfy.android.system.ActivityUtils;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.ui.base.BaseActivity;

@Layout(id = R.layout.activity_filedownload)
public class FileDownloadActivity extends BaseActivity {
    

    public static void startActivity() {
        ActivityUtils.startActivity(FileDownloadActivity.class);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewContent();
    }

    public void initViewContent() {

    }
}