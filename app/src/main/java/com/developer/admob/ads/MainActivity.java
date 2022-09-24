package com.developer.admob.ads;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.developer.admob.ads.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        loadBanner();
        loadNativeSmall();
        eventHandling();
        loadNativeMedium();
    }

    private void eventHandling() {
        binding.buttonInterstitial.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            showInterstitialAdDialog(intent);
        });
        binding.buttonReward.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            showRewardAdDialog(intent);
        });
        binding.buttonRewardedInterstitial.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            showRewardInterstitialAdDialog(intent);
        });
    }

    private void loadBanner() {
        AdView adView = new AdView(this);
        AdManager.displayBanner(this, adView, binding.bannerContainer);
    }

    private void loadNativeSmall() {
        AdManager.showNativeSmall(this, binding.nativeSmall);
    }
    private void loadNativeMedium() {
        AdManager.showNativeMedium(this, binding.nativeMedium);
    }









    private void showRewardInterstitialAdDialog(Intent intent) {
        if (AdManager.isRewardInterstitialLoad()) {
            AdManager.showRewardedInterstitial(MainActivity.this, intent);
        } else {
            AdManager.loadRewardedInterstitial(MainActivity.this);
            startActivity(intent);
        }
    }

    private void showRewardAdDialog(Intent intent) {
        if (AdManager.isRewardLoad()) {
            AdManager.showReward(MainActivity.this, intent);
        } else {
            AdManager.loadRewarded(MainActivity.this);
            startActivity(intent);
        }
    }

    private void showInterstitialAdDialog(Intent intent) {
        if (AdManager.isInterstitialLoad()) {
            AdManager.showInterstitial(MainActivity.this, intent);
        } else {
            AdManager.loadInterstitial(this);
            startActivity(intent);
        }
    }
}