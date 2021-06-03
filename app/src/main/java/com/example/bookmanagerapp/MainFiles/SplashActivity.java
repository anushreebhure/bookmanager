package com.example.bookmanagerapp.MainFiles;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bookmanagerapp.R;

public class SplashActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieAnimationView=findViewById(R.id.lottie);
        lottieAnimationView.animate().translationY(1800).setDuration(2500).setStartDelay(4000);

        //Handler updates the main thread from background thread or other than main thread
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { //run() takes no args,it establishes entry point to new thread
                Intent i=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);//Splash screen appears for 3 sec

    }
}