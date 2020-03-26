package com.example.hassgy.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.example.hassgy.R;
import com.ulfy.android.system.ActivityUtils;
import com.ulfy.android.task.TaskUtils;
import com.ulfy.android.task_transponder.ContentDataLoader;
import com.ulfy.android.task_transponder.OnReloadListener;
import com.example.hassgy.application.vm.MovieDetailsVM;
import com.example.hassgy.ui.base.TitleContentActivity;
import com.example.hassgy.ui.view.MovieDetailsView;
import com.ulfy.android.ui_injection.Layout;


public class SettingActivity extends TitleContentActivity {
    private MovieDetailsVM vm;
    private MovieDetailsView view;

    /*
      开启Activity
    */
    public static void startActivity() {
        ActivityUtils.startActivity(SettingActivity.class);
    }

    /* 初始化方法 */
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initModel(savedInstanceState);
        initContent(savedInstanceState);
        initActivity(savedInstanceState);
    }
    /*
    * 初始化模型
    * */
    private void initModel(Bundle savedInstanceState) {
        vm = new MovieDetailsVM();
    }

    /*初始化内容*/
    private void initContent(final Bundle savedInstanceState) {
        TaskUtils.loadData(getContext(), vm.loadDataOnExe(), new ContentDataLoader(contentFL, vm, false) {
                    @Override protected void onCreatView(ContentDataLoader loader, View createdView) {
                        view = (MovieDetailsView) createdView;
                    }
                }.setOnReloadListener(new OnReloadListener() {
                    @Override public void onReload() {
                        initContent(savedInstanceState);
                    }
                })
        );
    }
    /* 初始化Activity */
    private void initActivity(Bundle savedInstanceState) {
        titleTV.setText("设置"); 
    }
}

//public class Details2Activity extends TitleContentActivity {
//    private Details2VM vm;
//    private Details2View view;
//
//    /**
//     * 启动Activity
//     */
//    public static void startActivity() {
//        ActivityUtils.startActivity(Details2Activity.class);
//    }
//
//    /**
//     * 初始化方法
//     */
//    @Override protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initModel(savedInstanceState);
//        initContent(savedInstanceState);
//        initActivity(savedInstanceState);
//    }
//
//    /**
//     * 初始化模型和界面
//     */
//    private void initModel(Bundle savedInstanceState) {
//        vm = new Details2VM();
//    }
//
//    /**
//     * 初始化界面的数据
//     */
//    private void initContent(final Bundle savedInstanceState) {
//        TaskUtils.loadData(getContext(), vm.loadDataOnExe(), new ContentDataLoader(contentFL, vm, false) {
//                    @Override protected void onCreatView(ContentDataLoader loader, View createdView) {
//                        view = (Details2View) createdView;
//                    }
//                }.setOnReloadListener(new OnReloadListener() {
//                    @Override public void onReload() {
//                        initContent(savedInstanceState);
//                    }
//                })
//        );
//    }
//
//    /**
//     * 初始化Activity的数据
//     */
//    private void initActivity(Bundle savedInstanceState) {
//        titleTV.setText("详情页二");
//    }
//}