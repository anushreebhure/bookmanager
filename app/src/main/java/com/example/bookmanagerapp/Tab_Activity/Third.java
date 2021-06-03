package com.example.bookmanagerapp.Tab_Activity;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bookmanagerapp.Fragment_Activity.Feedback;
import com.example.bookmanagerapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
//code for ListView and showing toast inside Fragment
public class Third extends Fragment {
    TextView textView;


    public Third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_third, container, false);

        //Animation
        RelativeLayout relativeLayout=inflate.findViewById(R.id.layout_fragment3);
        AnimationDrawable animationDrawable=(AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        textView=(TextView) inflate.findViewById(R.id.first_tv);
        String text="Click here to fill the Feedback!";
        SpannableString ss=new SpannableString(text);
        ForegroundColorSpan fcspink=new ForegroundColorSpan(Color.MAGENTA);
        UnderlineSpan underlinespan=new UnderlineSpan();
        ss.setSpan(fcspink,0,10,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(underlinespan,0,10, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textView.setText(ss);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Feedback.class));
            }
        });
        return inflate;
    }

}

