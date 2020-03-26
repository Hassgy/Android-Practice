package com.example.hassgy.domain.cache;

import com.ulfy.android.cache.CacheUtils;

import java.io.Serializable;

public class AppCache implements Serializable {
    private static final long serialVersionUID = -5779821089279136150L;
    private boolean firstStart = true;      // 是否是第一次启动
    private String deviceId;                // 存储手机唯一标识

    private AppCache() { }

    public static AppCache getInstance() {
        return CacheUtils.isCached(AppCache.class) ? CacheUtils.getCache(AppCache.class) : CacheUtils.cache(new AppCache());
    }

    /**
     * 是否是首次启动
     * @return 首次调用返回true，之后的调用返回false
     */
    public boolean isFirstStart() {
        boolean firstStart = this.firstStart;
        if (firstStart) {
            this.firstStart = false;
            updateToCache();
        }
        return firstStart;
    }

    /**
     * 跟新设备唯一标识，在设备启动的时候更新
     *      目前代码存在问题（应该是只要缓存中存在就不会重复更新，因为设备id的获取有可能不一样，尽量减少更新可以减少出现不一样的概率）
     */
    public void updateDeviceId(String deviceId) {
        this.deviceId = deviceId;
        updateToCache();
    }

    /**
     * 获取设备唯一标识
     */
    public String deviceId() {
        return deviceId;
    }

    private void updateToCache() {
        CacheUtils.cache(this);
    }
}
