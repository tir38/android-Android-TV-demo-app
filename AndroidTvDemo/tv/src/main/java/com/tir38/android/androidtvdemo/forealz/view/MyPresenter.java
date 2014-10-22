package com.tir38.android.androidtvdemo.forealz.view;

import android.content.Context;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class MyPresenter extends Presenter {

    private static final String TAG = "MyPresenter";
    private Context mContext;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        Log.d(TAG, "onCreateViewHolder");

        mContext = parent.getContext();

        // instantiate view here
        ImageCardView imageCardView = new ImageCardView(mContext);

        // set params on imageCardView
        imageCardView.setFocusable(true);
        imageCardView.setFocusableInTouchMode(true);
        imageCardView.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_blue_bright));

        // create new ViewHolder, passing in view
        return new MyViewHolder(imageCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object object) {
        Log.d(TAG, "onBindViewHolder");
        // here we are "binding" the view to the object

        // cast object and view holder to appropriate classes
        Topic topic = (Topic) object;
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

        // Why do I pass the model object to the view holder
        // but update the view holder myself here? Why am I not calling
        // an updater method on the view holder?
        // i.e whats the point of having the view holder know about the model object?
//        myViewHolder.setTopic(topic);
        myViewHolder.mCardView.setTitleText(topic.getTitle());
        myViewHolder.mCardView.setMainImage(mContext.getDrawable(R.drawable.brian_up_close));

        // the short answer is that I SHOULD NOT BE DOING THIS.
        // the view holder is a VIEW holder, not a model holder
        // there is no benefit. Plus, that is exactly what the Presenter is doing
        // its binding the model to the view; so the Presenter should be the one
        // holding on to the model object.
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
        // unbind anything...
        // release memory heavy resources... bitmaps?
    }

    public static class MyViewHolder extends Presenter.ViewHolder {

        // THIS GUY HOLDS ON TO THE VIEW OBJECTS. DO NOT PUT YOUR MODEL HERE!
        ImageCardView mCardView;

        public MyViewHolder(View view) {

            super(view);
            Log.d(TAG, "MyViewHolder constructor");
            mCardView = (ImageCardView) view;
        }

        private void updateView() {
            // TODO
        }
    }
}
