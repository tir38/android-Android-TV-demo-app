package com.tir38.android.androidtvdemo.forealz;

import android.app.Fragment;

public class DemoActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment() {
        return DemoBrowseFragment.newInstance();
    }
}
