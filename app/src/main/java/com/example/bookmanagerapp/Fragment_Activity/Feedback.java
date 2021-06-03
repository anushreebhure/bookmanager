package com.example.bookmanagerapp.Fragment_Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmanagerapp.R;

public class Feedback extends AppCompatActivity {
    TextView tvfeedback;
    RatingBar rbStars;
    Button feedback_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        tvfeedback=findViewById(R.id.feedback_text);
        rbStars=findViewById(R.id.ratingbar);
        feedback_btn=findViewById(R.id.feedback_btn);

        TextView textView=findViewById(R.id.feedback1);
        String text="Feedback";
        SpannableString ss=new SpannableString(text);
        ForegroundColorSpan fcsWhite=new ForegroundColorSpan(Color.WHITE);
        ForegroundColorSpan fcsYellow=new ForegroundColorSpan(Color.YELLOW);
        ss.setSpan(fcsWhite,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsYellow,4,8,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);

        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                 if(rating==0){
                     tvfeedback.setText("Very Dissatisfied");
                 }
                 else if(rating==1){
                     tvfeedback.setText("Dissatisfied");
                 }
                 else if(rating==2||rating==3){
                     tvfeedback.setText("OK");
                 }
                 else if(rating==4){
                     tvfeedback.setText("Satisfied");
                 }
                 else if(rating==5){
                     tvfeedback.setText("Very Satisfied");
                 }
                 else{

                 }
            }
        });
        feedback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= String.valueOf(rbStars.getRating());
                Toast.makeText(getApplicationContext(),"You rated: "+s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}