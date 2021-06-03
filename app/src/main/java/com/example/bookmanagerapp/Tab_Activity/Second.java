package com.example.bookmanagerapp.Tab_Activity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.bookmanagerapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
//code for Service(play music) inside Fragment
public class Second extends Fragment {
Button play1,pause1,stop1,play2,pause2,stop2,play3,pause3,stop3,play4,pause4,stop4,play5,pause5,stop5;

    public Second() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_second, container, false);

        //Animation
        RelativeLayout relativeLayout=inflate.findViewById(R.id.layout_fragment2);
        AnimationDrawable animationDrawable=(AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        play1=(Button)inflate.findViewById(R.id.play1);
        pause1=(Button)inflate.findViewById(R.id.pause1);
        stop1=(Button)inflate.findViewById(R.id.stop1);
        play2=(Button)inflate.findViewById(R.id.play2);
        pause2=(Button)inflate.findViewById(R.id.pause2);
        stop2=(Button)inflate.findViewById(R.id.stop2);
        play3=(Button)inflate.findViewById(R.id.play3);
        pause3=(Button)inflate.findViewById(R.id.pause3);
        stop3=(Button)inflate.findViewById(R.id.stop3);
        play4=(Button)inflate.findViewById(R.id.play4);
        pause4=(Button)inflate.findViewById(R.id.pause4);
        stop4=(Button)inflate.findViewById(R.id.stop4);
        play5=(Button)inflate.findViewById(R.id.play5);
        pause5=(Button)inflate.findViewById(R.id.pause5);
        stop5=(Button)inflate.findViewById(R.id.stop5);
        final MediaPlayer sound1=MediaPlayer.create(getActivity(),R.raw.part1);
        final MediaPlayer sound2=MediaPlayer.create(getActivity(),R.raw.parrt2);
        final MediaPlayer sound3=MediaPlayer.create(getActivity(),R.raw.part3);
        final MediaPlayer sound4=MediaPlayer.create(getActivity(),R.raw.part4);
        final MediaPlayer sound5=MediaPlayer.create(getActivity(),R.raw.part5);
        play1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sound1.setLooping(true);
                sound1.start();
            }
        });
        pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound1.isPlaying()){
                    sound1.pause();
                }
            }
        });
        stop1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if(sound1.isPlaying()){
                    sound1.stop();
                }
            }
        });
        play2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sound2.setLooping(true);
                sound2.start();
            }
        });
        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound2.isPlaying()){
                    sound2.pause();
                }
            }
        });
        stop2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if(sound2.isPlaying()){
                    sound2.stop();
                }
            }
        });
        play3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sound3.setLooping(true);
                sound3.start();
            }
        });
        pause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound3.isPlaying()){
                    sound3.pause();
                }
            }
        });
        stop3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if(sound3.isPlaying()){
                    sound3.stop();
                }
            }
        });
        play4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sound4.setLooping(true);
                sound4.start();
            }
        });
        pause4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound4.isPlaying()){
                    sound4.pause();
                }
            }
        });
        stop4.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if(sound4.isPlaying()){
                    sound4.stop();
                }
            }
        });
        play5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sound5.setLooping(true);
                sound5.start();
            }
        });
        pause5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound5.isPlaying()){
                    sound5.pause();
                }
            }
        });
        stop5.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if(sound5.isPlaying()){
                    sound5.stop();
                }
            }
        });
        return inflate;
    }




}
