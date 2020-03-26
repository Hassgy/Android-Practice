package com.example.hassgy.application.vm;

import com.example.hassgy.domain.entity.Advertisement;
import com.ulfy.android.image.ImageUtils;
import com.ulfy.android.task.LoadDataUiTask;
import com.ulfy.android.utils.LogUtils;

public class SplashVM {
    public Advertisement advertisement;

    public LoadDataUiTask.OnExecute loadSplashDataOnExe() {
        return new LoadDataUiTask.OnExecute() {
            @Override public void onExecute(LoadDataUiTask task) {
                try {
                    task.notifyStart("正在加载...");

                    // 模拟广告加载过程
                    Thread.sleep(1000);
                    Advertisement advertisement = new Advertisement();
                    advertisement.cover = "http://shp.qpic.cn/ishow/2735031110/1583893817_84828260_2491_sProdImgNo_6.jpg/0";
                    advertisement.url = "https://pvp.qq.com/";

                    // 预先将广告图片加载到本地
                    if (advertisement != null) {    // 防止后台返回错误数据
                        ImageUtils.download(advertisement.cover);
                    }

                    // 整个过程结束后才设置成员变量
                    SplashVM.this.advertisement = advertisement;

                    task.notifySuccess("加载完成");
                } catch (Exception e) {
                    LogUtils.log("加载失败", e);
                    task.notifyFail(e);
                }
            }
        };
    }

}
