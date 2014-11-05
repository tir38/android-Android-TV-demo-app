package com.tir38.android.androidtvdemo.forealz.model;


import android.util.Log;

import com.tir38.android.androidtvdemo.R;
import com.tir38.android.androidtvdemo.forealz.model.topics.AvailableDevicesTopic;
import com.tir38.android.androidtvdemo.forealz.model.topics.GameControllerTopic;
import com.tir38.android.androidtvdemo.forealz.model.topics.GoogleDocsTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Everything in this class is ugly. Do not mimic the behavior here.
 * This is just a hacky way to provide data to the "important" parts of this app.
 */
public class ModelStore {

    private static final String TAG = "ModelStore";
    public static final String BASE_IMAGE_RESOURCE_URL = "https://raw.githubusercontent.com/tir38/Android-TV-demo-app/master/AndroidTvDemo/tv/src/main/res/drawable/";

    private static ModelStore sModelStore;

    private List<String> mCategories = new ArrayList<String>();
    private List<List<Topic>> mTopics = new ArrayList<List<Topic>>();

    /**
     * must instantiate with getModelStore()
     */
    private ModelStore() {
        // setup categories
        mCategories.add("As a user");
        mCategories.add("General dev stuff");
        mCategories.add("Details Details Details!");

        // TODO: make the rest of these topics their own objects

        // setup topics
        Topic[] category1Topics = {new AvailableDevicesTopic(),
                new GameControllerTopic(),
                new Topic("Remote Control", 4, R.string.todo),
                new Topic("Remote Control Android App", 5, R.string.todo),
                new Topic("Home Screen", 3, R.string.home_screen_description)};

        Topic[] category2Topics = {new GoogleDocsTopic(),
                new Topic("Google TV vs. AndroidTV", 44, R.string.todo)};

        Topic[] category3Topics = {new Topic("Adapter + View pattern", 555, R.string.todo)};

        mTopics.add(new ArrayList<Topic>(Arrays.asList(category1Topics)));
        mTopics.add(new ArrayList<Topic>(Arrays.asList(category2Topics)));
        mTopics.add(new ArrayList<Topic>(Arrays.asList(category3Topics)));
    }

    /**
     * Singleton pattern
     */
    public static ModelStore getModelStore() {
        if (sModelStore == null) {
            sModelStore = new ModelStore();
        }
        return sModelStore;
    }

    public List<String> getCategories() {
        return mCategories;
    }

    public List<Topic> getTopicsByCategory(int categoryIndex) {
        // make sure category index has topics
        if (categoryIndex >= mTopics.size()) {
            Log.e(TAG, "Attempting to access Category index that doesn't have any topics.");
            return null;
        }

        return mTopics.get(categoryIndex);
    }

    public Topic getTopicById(int id) {
        for (List<Topic> topics : mTopics) {
            for (Topic topic : topics) {
                if (topic.getId() == id) {
                    return topic;
                }
            }
        }
        Log.e(TAG, "can't find topic with id: " + id);
        return null;
    }
}