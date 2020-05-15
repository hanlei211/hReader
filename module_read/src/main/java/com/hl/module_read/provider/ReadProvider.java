package com.hl.module_read.provider;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hl.lib.common.provider.INewsProvider;
import com.hl.module_read.ui.fragment.ReadFragment;

/**
 * created by hl
 * on 2020/5/15
 */
@Route(path = "/read/main",name = "首页")
public class ReadProvider implements INewsProvider {


    @Override
    public Fragment getMainNewsFragment() {
        return ReadFragment.newsI;
    }

    @Override
    public void init(Context context) {

    }
}
