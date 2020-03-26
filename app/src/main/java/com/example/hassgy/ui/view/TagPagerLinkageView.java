package com.example.hassgy.ui.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ulfy.android.bus.BusUtils;
import com.ulfy.android.mvvm.IViewModel;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.ui.base.BaseView;
import com.ulfy.android.ui_injection.ViewClick;
import com.ulfy.android.ui_linkage.OnTabSelectedListener;
import com.ulfy.android.ui_linkage.TabPagerLinkage;
import com.example.hassgy.application.vm.TabPagerLinkageVM;
import com.ulfy.android.utils.UiUtils;

@Layout(id = R.layout.activity_tagpage)
public class TagPagerLinkageView extends BaseView {
    @ViewById(id = R.id.tabTL) private TabLayout tabTL;
//    @ViewById(id = R.id.magicMI) private MagicIndicator magicMI;
    @ViewById(id = R.id.tab1FL) private FrameLayout tab1FL;
    @ViewById(id = R.id.tab2FL) private FrameLayout tab2FL;
    @ViewById(id = R.id.containerVP) private ViewPager containerVP;
    @ViewById(id = R.id.containerFL) private FrameLayout containerFL;
    @ViewById(id = R.id.tabPage1LL) private LinearLayout tabPage1LL;
    @ViewById(id = R.id.tabPage2LL) private LinearLayout tabPage2LL;

    private TabPagerLinkage linkage = new TabPagerLinkage();
//    private MagicTabPagerLinkage linkage = new MagicTabPagerLinkage();
    private TabPagerLinkageVM vm;

    public TagPagerLinkageView(Context context) {
        super(context);
        init(context, null);
    }

    public TagPagerLinkageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        linkage
                .setContainer(containerVP)
                .setTabLayout(tabTL)     // 支持ViewGroup、ViewPager、ViewGroupId（Fragment用）
                .addOnTabSelectedListener(new OnTabSelectedListener() {
                    @Override public void onTabSelected(int index) {
                        UiUtils.show("选中了标签页：" + index);
                    }
                })
        ;
    }

    @Override public void bind(IViewModel model) {
        vm = (TabPagerLinkageVM) model;
        if (vm.useViewPager) {
            linkage.setContainer(containerVP);
        } else {
            linkage.setContainer(containerFL);
        }

        if (vm.fullScreen) {
            linkage.initViewPages(tabPage1LL, tabPage2LL, new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext()));
        } else {
            linkage.initViewPages(tabPage1LL, tabPage2LL);
        }


        linkage
                .initStringTabs("标签页1", "标签页标签页")              // 字符串方式标题
                .initViewTabs(tab1FL, tab2FL)                           // View方式标题
                .initViewPages(tabPage1LL, tabPage2LL)                  // 具体的标签页（支持View、Fragment）
                // 线宽的三种模式：填充、包裹、固定长度。默认填充
                .setLineWidth(TabPagerLinkage.LINE_WIDTH_MATCH_PARENT)
                .setLineWidth(TabPagerLinkage.LINE_WIDTH_WRAP_CONTENT)
                .setLineWidth(UiUtils.dp2px(20))
                // 当界面不够大是是否自动切换为MODE_SCROLLABLE模式
                .setAutoScrollMode(true)
                // 在滚动模式下使用包裹方案显示下划线
                .setUseWrapperOnScrollMode(true)
                // 对TabPagerLinkage.LINE_WIDTH_WRAP_CONTENT、TabLayout.MODE_FIXED模式下设置无效
                .setDividerWidth(UiUtils.dp2px(10))
                .build().select(0)
        ;
    }
}