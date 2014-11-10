package com.tir38.android.androidtvdemo.forealz.model.topics;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.Topic;

public class ContentTopic extends Topic {
    public ContentTopic() {
        super("Content is Everything",
                3333,
                R.string.content_description);
        setImageUrl("content.jpg");
        setBackgroundImageUrl("http://www.bookaliciousmama.com/wp-content/uploads/2014/02/Piles-of-books-in-a-private-college-library_www.LuxuryWallpapers.net_.jpg");
    }
}
