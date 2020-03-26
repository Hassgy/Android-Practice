package com.example.hassgy.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hassgy.application.vm.TabPagerLinkageVM;
import com.example.hassgy.ui.view.TagPagerLinkageView;
import com.example.hassgy.ui.base.TitleContentActivity;
import com.ulfy.android.bus.Subscribe;
import com.ulfy.android.system.ActivityUtils;
import com.ulfy.android.task.TaskUtils;
import com.ulfy.android.task_transponder.ContentDataLoader;
import com.ulfy.android.task_transponder.OnReloadListener;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.ui.base.BaseActivity;

public class TabPagerLinkageActivity extends TitleContentActivity {
    private TabPagerLinkageVM vm;
    private TagPagerLinkageView view;

    public static void startActivity() {
        ActivityUtils.startActivity(TabPagerLinkageActivity.class);
    }

    /**
     * 初始化方法
     */
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initModel(savedInstanceState);
        initContent(savedInstanceState);
        initActivity(savedInstanceState);
    }

    /**
     * 初始化模型和界面
     */
    private void initModel(Bundle savedInstanceState) {
        vm = new TabPagerLinkageVM();
    }

    /**
     * 初始化界面的数据
     */
    private void initContent(final Bundle savedInstanceState) {
        TaskUtils.loadData(getContext(), vm.loadDataOnExe(), new ContentDataLoader(contentFL, vm, false) {
                    protected void onCreatView(ContentDataLoader loader, View createdView) {
                        view = (TagPagerLinkageView) createdView;
                    }
                }.setOnReloadListener(new OnReloadListener() {
                    public void onReload() {
                        initContent(savedInstanceState);
                    }
                })
        );
    }

    /**
     * 初始化Activity的数据
     */
    private void initActivity(Bundle savedInstanceState) {
        titleTV.setText("标签页");
    }

    @Subscribe
    public void RequestReloadEvent(RequestReloadEvent event) {
        initContent(null);
    }

    /**
     * 页面重新加载
     */
    public static class RequestReloadEvent {}
}