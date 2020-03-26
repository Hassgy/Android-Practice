package com.example.hassgy.application.vm;

import com.ulfy.android.mvvm.IView;
import com.ulfy.android.task.LoadDataUiTask;
import com.ulfy.android.ui_linkage.TabPagerLinkage;
import com.example.hassgy.application.base.BaseVM;
import com.example.hassgy.ui.view.TagPagerLinkageView;

public class TabPagerLinkageVM extends BaseVM {
    public static final int TAB_TYPE_STRING = 0;        // 使用字符串显示顶部的Tab
    public static final int TAB_TYPE_VIEW = 1;          // 使用View显示顶部的Tab

    public boolean useViewPager = true;                 // 是否使用ViewPager作为显示容器
    public boolean fullScreen;                          // 顶部Tab的数量是否可以填满屏幕
    public boolean useWrapperOnScrollMode;              // 在滚动模式下是否启动包裹：启动包裹线条宽度可以在有间距的情况下和内容同齐
    public int tabType = TAB_TYPE_STRING;               // 顶部Tab显示模式
    public int lineWidth = TabPagerLinkage.LINE_WIDTH_MATCH_PARENT;     // 线条的宽度

    /**
     * 加载数据：
     */
    public LoadDataUiTask.OnExecute loadDataOnExe() {
        return new LoadDataUiTask.OnExecute() {
            public void onExecute(LoadDataUiTask task) {
                try {
                    task.notifyStart("正在加载...");

                    task.notifySuccess("加载完成");
                } catch (Exception e) {
                    e.printStackTrace();
                    task.notifyFail(e);
                }
            }
        };
    }

    @Override
    public Class<? extends IView> getViewClass() {
        return TagPagerLinkageView.class;
    }
}