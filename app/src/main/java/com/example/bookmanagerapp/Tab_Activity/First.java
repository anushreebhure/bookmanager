package com.example.bookmanagerapp.Tab_Activity;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bookmanagerapp.Fragment_Activity.HomeActivity;
import com.example.bookmanagerapp.R;
import com.example.bookmanagerapp.Tab_Activity.FirstHelper.PDFOpener;

/**
 * A simple {@link Fragment} subclass.
 */
//code for ListView and showing PDF inside fragment(PDF are downloaded inside assets)
public class First extends Fragment {
    TextView textView;
    public First(){


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_first, container, false);

//Animation
        RelativeLayout relativeLayout=inflate.findViewById(R.id.layout_fragment1);
        AnimationDrawable animationDrawable=(AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        textView=(TextView) inflate.findViewById(R.id.first_tv);
        String text="View Books";
        SpannableString ss=new SpannableString(text);
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent=new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getResources().getColor(R.color.newcolor));
            }
        };
        ss.setSpan(clickableSpan,0,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        final String[] pdffiles={"HTML and CSS Crash Course","Coding Interview Ninja_50 Coding Questions",
                "Javascript","LINUX Command Line","Resisting Happiness"};
        final ListView listView_1 = (ListView) inflate.findViewById(R.id.listView_1);
        ArrayAdapter<String> aa2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,pdffiles);
        listView_1.setAdapter(aa2);
        listView_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item= listView_1.getItemAtPosition(position).toString();//data at specified position stored in item String
                Intent intent=new Intent(getActivity(), PDFOpener.class);//to open pdf from other class after selecting book
                intent.putExtra("pdfFileName",item);//pdfFileName is a key to which item String is passed(data in item is passed)
                startActivity(intent);
            }
        });
        return inflate;
    }

}

