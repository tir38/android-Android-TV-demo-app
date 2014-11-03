package com.tir38.android.androidtvdemo.forealz;

import android.app.Fragment;

public class MyBrowseActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment() {
        return MyBrowseFragment.newInstance();
    }
}
