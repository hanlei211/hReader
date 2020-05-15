package com.hl.module_main;


import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hl.lib.common.base.BaseActivity;
import com.hl.lib.common.provider.IAttentionProvider;
import com.hl.lib.common.provider.IMeProvider;
import com.hl.lib.common.provider.INewsProvider;
import com.hl.lib.common.provider.IVideoProvider;
import com.hl.module_main.entity.MainChannel;

public class MainActivity extends BaseActivity {

    @Autowired(name = "/read/main")
    INewsProvider mNewsProvider;

    @Autowired(name = "/message/main")
    IVideoProvider mVideoProvider;

    @Autowired(name = "/me/main")
    IMeProvider mMeProvider;

    private Fragment mNewsFragment;
    private Fragment mVideoFragment;
    private Fragment mMeFragment;
    private Fragment mCurrFragment;

    @Override
    public int onBindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        BottomNavigationView navigation = this.findViewById(R.id.bt_navigation);
        //底部导航栏选择切换
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int i = menuItem.getItemId();
                if (i == R.id.navigation_trip) {
                    switchContent(mCurrFragment, mNewsFragment, MainChannel.NEWS.name);
                    mCurrFragment = mNewsFragment;
                    return true;
                }else if (i == R.id.navigation_video) {
                    switchContent(mCurrFragment, mVideoFragment, MainChannel.VIDEO.name);
                    mCurrFragment = mVideoFragment;
                    return true;
                } else if (i == R.id.navigation_me) {
                    switchContent(mCurrFragment, mMeFragment, MainChannel.ME.name);
                    mCurrFragment = mMeFragment;
                    return true;
                }
                return false;
            }
        });
        if(mNewsProvider != null){
            mNewsFragment = mNewsProvider.getMainNewsFragment();
        }
        if(mVideoProvider != null){
            mVideoFragment = mVideoProvider.getMainVideoFragment();
        }
        if(mMeProvider != null){
            mMeFragment = mMeProvider.getMainMeFragment();
        }
        mCurrFragment = mNewsFragment;
        if(mNewsFragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, mNewsFragment, MainChannel.NEWS.name).commit();
        }
    }

    public void switchContent(Fragment start, Fragment to, String tag) {
        if (start == null || to == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!to.isAdded()) {
            transaction.hide(start).add(R.id.frame_content, to, tag).commit();
        } else {
            transaction.hide(start).show(to).commit();
        }
    }

    @Override
    public boolean enableToolbar() {
        return false;
    }

    @Override
    public void initData() {

    }

    @Override
    public void showNetErrView() {

    }

    @Override
    public void hideNetErrView() {

    }
}
