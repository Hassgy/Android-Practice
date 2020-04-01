package com.example.hassgy.ui.activity;

import android.view.View;

import com.example.hassgy.R;
import com.example.hassgy.ui.base.BaseActivity;
import com.ulfy.android.system.AppUtils;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewClick;

@Layout(id = R.layout.activity_main)
public class MainActivity extends BaseActivity {

//    @Override protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    /**
     * click: startPageBtn, guidePageBtn, tagPageBtn, detailPageBtn, listPageBtn, searchPageBtn, upgradePageBtn, webViewLoadPageBtn, fileDownloadPageBtn
     *
     */
    @ViewClick(ids = {R.id.startPageBtn, R.id.guidePageBtn, R.id.tagPageBtn, R.id.detailPageBtn, R.id.listPageBtn, R.id.searchPageBtn, R.id.upgradePageBtn, R.id.webViewLoadPageBtn, R.id.fileDownloadPageBtn})
    private void clickGroup(View v) {
        switch (v.getId()) {
            case R.id.startPageBtn:
                SplashActivity.startActivity();
                break;
            case R.id.guidePageBtn:
                GuideActivity.startActivity();
                break;
            case R.id.tagPageBtn:
                TabPagerLinkageActivity.startActivity();
                break;
            case R.id.detailPageBtn:
                SettingActivity.startActivity();
                break;
            case R.id.listPageBtn:
                NoticeActivity.startActivity();
                break;
            case R.id.searchPageBtn:
                ContentSearchActivity.startActivity();
                break;
            case R.id.upgradePageBtn:
                UpgradeCheckActivity.startActivity();
                break;
            case R.id.webViewLoadPageBtn:
                WebActivity.startActivity();
                break;
            case R.id.fileDownloadPageBtn:
                break;
            default:
                break;
        }
    }



    @Override public void onBackPressed() {
        AppUtils.exitTwice("再按一次退出" + AppUtils.getAppName());
    }
}