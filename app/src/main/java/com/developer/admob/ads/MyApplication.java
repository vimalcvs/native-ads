package com.developer.admob.ads;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class MyApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this);
        AdManager.loadInterstitial(this);
        AdManager.loadRewarded(this);
        AdManager.loadRewardedInterstitial(this);

    }
}
