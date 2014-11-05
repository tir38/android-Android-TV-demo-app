package com.tir38.android.androidtvdemo.forealz.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.ModelStore;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class BrowseTopicPresenter extends Presenter {

    private static final String TAG = "MyPresenter";
    private static Context sContext;

    public BrowseTopicPresenter() {
        Log.d(TAG, "instantiating " + BrowseTopicPresenter.class.toString());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        sContext = parent.getContext();

        // instantiate view here
        ImageCardView imageCardView = new ImageCardView(sContext);

        // set params on imageCardView
        imageCardView.setFocusable(true);
        imageCardView.setFocusableInTouchMode(true);
        imageCardView.setBackgroundColor(sContext.getResources().getColor(android.R.color.holo_blue_bright));

        // create new ViewHolder, passing in view
        return new BrowseTopicPresenterViewHolder(imageCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object object) {
        // here we are "binding" the view to the object

        // cast object to appropriate class
        Topic topic = (Topic) object;

        // update ViewHolder
        BrowseTopicPresenterViewHolder browseTopicPresenterViewHolder = (BrowseTopicPresenterViewHolder) viewHolder;
        browseTopicPresenterViewHolder.mCardView.setTitleText(topic.getTitle());

        // load image w/ Picasso
        Uri uri = Uri.parse(ModelStore.BASE_IMAGE_RESOURCE_URL + topic.getImageUrl());
        browseTopicPresenterViewHolder.updateCardViewImage(uri);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        // TODO: do i want to do this?
//        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
//        myViewHolder.mCardView = null;
        // unbind anything; release memory heavy resources... bitmaps?
    }

    /**
     * THIS GUY HOLDS ONTO  VIEW-RELATED OBJECTS.
     * DO NOT PUT YOUR MODEL HERE!
     * TODO: WELL MAYBE....FIGURE OUT WHAT THE LIFECYCLE OF THIS GUY IS.
     */
    public static class BrowseTopicPresenterViewHolder extends Presenter.ViewHolder {

        private static final int CARD_WIDTH = 400;
        private static final int CARD_HEIGHT = 400;
        private ImageCardView mCardView;
        private CardImageTarget mTarget;

        public BrowseTopicPresenterViewHolder(View view) {
            super(view);
            Log.d(TAG, "instantiating " + BrowseTopicPresenterViewHolder.class.toString());
            mCardView = (ImageCardView) view;
            mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
            mTarget = new CardImageTarget(mCardView);
        }

        protected void updateCardViewImage(Uri uri) {
            Picasso.with(sContext)
                    .load(uri)
                    .resize(CARD_WIDTH, CARD_HEIGHT)
                    .centerInside()
                    .placeholder(R.drawable.brian_up_close)
                    .error(R.drawable.brian_up_close)
                    .into(mTarget);
        }
    }

    /**
     * Picasso Target
     */
    private static class CardImageTarget implements Target {

        private ImageCardView mCardView;

        private CardImageTarget(ImageCardView cardView) {
            mCardView = cardView;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(sContext.getResources(), bitmap);
            mCardView.setMainImage(bitmapDrawable);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            mCardView.setMainImage(errorDrawable);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            mCardView.setMainImage(placeHolderDrawable);
        }
    }
}
