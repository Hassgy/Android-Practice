package com.example.hassgy.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hassgy.application.vm.SplashVM;
import com.example.hassgy.domain.cache.AppCache;
import com.ulfy.android.image.ImageUtils;
import com.ulfy.android.system.ActivityUtils;
import com.ulfy.android.system.AppUtils;
import com.ulfy.android.task.TaskUtils;
import com.ulfy.android.task_extension.UiTimer;
import com.ulfy.android.task_transponder.SilentProcesser;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.ui.base.BaseActivity;
import com.ulfy.android.ui_injection.ViewClick;
import com.ulfy.android.utils.StatusBarUtils;
import com.ulfy.android.utils.UiUtils;

@Layout(id = R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
    @ViewById(id = R.id.splashIV) private ImageView splashIV;
    @ViewById(id = R.id.skipTV) private TextView skipTV;
    private boolean autoSkip = true;                                // 倒计时结束后页面是否自动跳转
    private UiTimer uiTimer = new UiTimer(1000);
    private SplashVM vm = new SplashVM();


    public static void startActivity() {
        ActivityUtils.startActivity(SplashActivity.class);
    }

    /*
        测试用例：
            1. 定时器开始前倒计时按钮不显示
            2. 定时器开始后显示倒计时按钮，且按钮不可点击
            3. 定时器结束后：自动跳转到首页（自动跳转模式）、跳转按钮显示进入（非自动跳转模式）
            5. 非自动跳转模式：定时器结束后点击按钮进入首页
     */

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        skipTV.setVisibility(View.GONE);
        // 启动逻辑
        if (AppCache.getInstance().isFirstStart()) {
            gotoGuideActivity();
        } else {
            loadSplashDataThenDo(new Runnable() {
                @Override public void run() {
                    ImageUtils.loadImage(vm.advertisement.cover, splashIV);
                    initTimer();
                    uiTimer.schedule();
                }
            });
        }
    }

    /**
     * 加载完启动页数据后执行指定的操作
     */
    private void loadSplashDataThenDo(Runnable runnable) {
        TaskUtils.loadData(getContext(), vm.loadSplashDataOnExe(), new SilentProcesser() {
                    @Override public void onSuccess(Object tipData) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                }
        );
    }

    /**
     * 初始化定时器
     */
    private void initTimer() {
        uiTimer.setUiTimerExecuteBody((timer, timerDriver) -> {
            // 定时器执行回调：这里可以设置按钮上的文字
            skipTV.setText(String.format("%d", ((UiTimer.NumberTimerDriver) timerDriver).getCurrentNumber()));
        }).setOnTimerStartListener((uiTimer, timerDriver) -> {
            // 定时器开始回调：这里可以设置按钮可见、按钮不可点击等
            skipTV.setVisibility(View.VISIBLE);
            skipTV.setEnabled(false);
        }).setOnTimerFinishListener((timer, timerDriver) -> {
            // 定时器结束回调：这可可以根据情况设置是否自动跳转
            if (autoSkip) {
                gotoMainActivity();
            } else {
                skipTV.setEnabled(true);
                skipTV.setText("进入");
            }
        }).setTimerDriver(new UiTimer.NumberTimerDriver(5, 1, 1, false, true));
    }

    /**
     * 点击按钮进入主页
     */
    @ViewClick(ids = R.id.skipTV) private void skipTV(View v) {
        gotoMainActivity();
    }

    /**
     * 点击广告
     */
    @ViewClick(ids = R.id.splashIV) private void splashIV(View v) {
        if (vm.advertisement != null) {
            gotoMainActivity();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override public void run() {
                    AppUtils.launchSystemBrowser(vm.advertisement.url);
                }
            }, 100);
        }
    }

    /**
     * 前往引导页
     */
    private void gotoGuideActivity() {
        UiUtils.show("打开了引导页");     // 替换为具体的启动页实现
        finish();
    }

    /**
     * 前往主页面
     */
    private void gotoMainActivity() {
        uiTimer.cancel();
        startActivity(new Intent(getContext(), MainActivity.class));
        finish();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        uiTimer.cancel();               // 注意及时取消定时器
    }
}