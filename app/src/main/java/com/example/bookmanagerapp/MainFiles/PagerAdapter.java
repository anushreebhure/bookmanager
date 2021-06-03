package com.example.bookmanagerapp.MainFiles;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bookmanagerapp.Tab_Activity.First;
import com.example.bookmanagerapp.Tab_Activity.Second;
import com.example.bookmanagerapp.Tab_Activity.Third;

//fragment inside tab code
public class PagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;//to keep the track of tabs in tab layout

    public PagerAdapter(@NonNull FragmentManager fm, int behavior,int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {//get the position of tab user has clicked on(0:Home)
        switch (position){
            case 0:
                return new First();//display the content inside First() fragment
            case 1:
                return new Second();
            case 2 :
                return new Third();
                default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
