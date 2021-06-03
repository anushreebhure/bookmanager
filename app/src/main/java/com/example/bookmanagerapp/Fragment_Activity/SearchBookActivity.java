package com.example.bookmanagerapp.Fragment_Activity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.bookmanagerapp.Fragment_Activity.HomeActivityHelper.BookLoader;
import com.example.bookmanagerapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchBookActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private static final String TAG = SearchBookActivity.class.getSimpleName();
    private EditText mBookInput;
    private TextView mAuthorText, mTitleText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Animation
        LinearLayout linearLayout=findViewById(R.id.search_fragment);
        AnimationDrawable animationDrawable=(AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        mBookInput = (EditText) findViewById(R.id.bookInput);
        mAuthorText = (TextView) findViewById(R.id.authoText);
        mTitleText = (TextView) findViewById(R.id.titleText);

        //When the device is rotated the view data is lost. This is because when the Activity is created(or recreated)
        //the Activity does not know there is a loader running.
        //An initLoader() method is needed in onCreate() of Download_book to reconnect to the loader.

        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();

        //For hiding the keyboard when the search button is clicked
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        //For checking the network state and empty search field case
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0) {

            //new FetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mTitleText.setText(R.string.loading);
            //We replace the call to execute the FetchBook task with a call to restartLoader(), passing in the query
            //string you got from the EditText in the Bundle
            Bundle queryBundle=new Bundle();
            queryBundle.putString("queryString",queryString);
            getSupportLoaderManager().restartLoader(0,queryBundle,this);
            /*
            * The restartLoader() method takes 3 args:
            * *A loader id
            * * An args Bundle(this is where any data needed by the loader goes)
            * *The instance of LoaderCallBacks you implemented in your activity. We want the loader to
            * * deliver the results to the SearchBookActivity, henc e we pass this as an argument
             */
        } else {
            if (queryString.length() == 0) {
                mAuthorText.setText("");
                mTitleText.setText("Please enter a search term.");
            } else {
                mAuthorText.setText("");
                mTitleText.setText("Please check your network connection and try again");
            }

        }

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        //onCreateLoader)() is called when you instantiate your Loader.
        return new BookLoader(this, args.getString("queryString"));

    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        //Called when the loader's task finishes. This is where you add the code to upgrade your UI
        //with the results
        //JSON
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject book = itemsArray.getJSONObject(i);
                String title = null;
                String authors = null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                //If both a title and author exists, update the TextViews and return
                if (title != null && authors != null) {
                    mTitleText.setText(title);
                    mAuthorText.setText(authors);
                    return;

                }
            }

            mTitleText.setText("No results Found");
            mAuthorText.setText("");


        } catch (Exception e) {
            mTitleText.setText("No results Found");
            mAuthorText.setText("");
            e.printStackTrace();
        }

    }
    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}