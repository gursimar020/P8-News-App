package com.example.android.a247newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.net.URL;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<NewsStory>>{

    private URL url;

    public NewsLoader(Context context, URL url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<NewsStory> loadInBackground() {
        String json = QueryUtils.fetchJsonResponse(url);
        Log.d("Main Activity", "Got json:" + json);
        return QueryUtils.fetchNewsStories(json);
    }
}
