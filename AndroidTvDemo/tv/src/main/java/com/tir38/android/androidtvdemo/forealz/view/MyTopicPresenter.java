package com.tir38.android.androidtvdemo.forealz.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class MyTopicPresenter extends Presenter {

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

        // cast object to appropriate class
        Topic topic = (Topic) object;

        // update ViewHolder
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.mCardView.setTitleText(topic.getTitle());

        // WTF? I have to resize my image here?
        Drawable mainImage = mContext.getDrawable(topic.getImageResId());
        Bitmap bitmap = ((BitmapDrawable)mainImage).getBitmap();

        // compute new height/width
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int desiredHeight = mContext.getResources().getInteger(R.integer.topic_card_desired_height);
        float scalingFactory = (float) desiredHeight/height;
        height = desiredHeight;
        width = (int) (scalingFactory * width);

        Bitmap bitmapResized = Bitmap.createScaledBitmap(bitmap, width, height, false);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mContext.getResources(), bitmapResized);
        myViewHolder.mCardView.setMainImage(bitmapDrawable);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
        // unbind anything; release memory heavy resources... bitmaps?
    }

    /**
     * THIS GUY HOLDS ON TO THE VIEW OBJECTS. DO NOT PUT YOUR MODEL HERE!
     */
    public static class MyViewHolder extends Presenter.ViewHolder {

        ImageCardView mCardView;

        public MyViewHolder(View view) {
            super(view);
            Log.d(TAG, "MyViewHolder constructor");
            mCardView = (ImageCardView) view;
        }
    }
}
