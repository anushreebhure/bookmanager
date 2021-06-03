package com.example.bookmanagerapp.Fragment_Activity.HomeActivityHelper;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {
    private String mQueryString;
    public BookLoader(@NonNull Context context,String queryString) {
        super(context);
        mQueryString=queryString;
    }
//Ctrl+O
    @Override
    protected void onStartLoading() {
        forceLoad(); //forceLoad() to start the loadInBackground() method once the Loader is created.
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
}
