package com.tir38.android.androidtvdemo.forealz.view;

import android.support.v17.leanback.widget.Presenter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        // TODO: can I inflate a view here and hand it to the ViewHolder?

        // Of course I can call view constructors
        TextView myTextView = new TextView(parent.getContext());
        return new MyViewHolder(myTextView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object object) {
        // here we are "binding" the view to the object
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        // unbind anything...
        // release memmory heavy resources... bitmaps?

        // I can clear stuff out if I want
        ((TextView) viewHolder.view).setText("");
    }

    public static class MyViewHolder extends Presenter.ViewHolder {

        public MyViewHolder(View view) {
            super(view);
        }


    }
}
