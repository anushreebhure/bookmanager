package com.example.bookmanagerapp.MainFiles;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bookmanagerapp.Fragment_Activity.Feedback;
import com.example.bookmanagerapp.Fragment_Activity.MyBookActivity;
import com.example.bookmanagerapp.Fragment_Activity.HomeActivity;
import com.example.bookmanagerapp.Fragment_Activity.SearchBookActivity;
import com.example.bookmanagerapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager pager;//to display content when tab is clicked
    TabLayout mTabLayout;
    TabItem firstItem,secondItem,thirdItem;//TabItem variables
    PagerAdapter adapter;//to display data into fragments
    private AlertDialog.Builder builder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);
        Toolbar toolbar = findViewById(R.id.toolbar);//select androidx Toolbar
        setSupportActionBar(toolbar);

        pager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tablayout);

        firstItem = findViewById(R.id.firstItem);
        secondItem = findViewById(R.id.secondItem);
        thirdItem = findViewById(R.id.thirditem);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);//to close nav bar

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);//we want the drawer to open
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();//keep track of if the drawer is open or close

        adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mTabLayout.getTabCount());
        pager.setAdapter(adapter);





        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);//nav drawer should close automatically
        if(item.getItemId() == R.id.home){
            Intent intent=new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);

        }
        if(item.getItemId() == R.id.db_book){
            Intent intent=new Intent(MainActivity.this, MyBookActivity.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.search_book){
            Intent intent=new Intent(MainActivity.this, SearchBookActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.feedback){
            Intent intent=new Intent(MainActivity.this, Feedback.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.send){
            Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.share){
            openShareButton();
        }
        return false;
    }
//code for share button in nav drawer
    private void openShareButton() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Download BookManager app here!!");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Download BookManager app from here!!!");
        shareIntent.setType("text/plain");
        startActivity(shareIntent);
    }
    public void onBackPressed() {
        builder.setMessage("Do you want to close this application?")
                .setCancelable(true)//back button
                .setIcon(R.drawable.iconbook)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        HeadsUpNotification notification=new HeadsUpNotification(getApplicationContext());
                        notification.getNotification("Hey!","Press here to go back!");

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();//code for creating alert Box.
        alert.setTitle("Exit");
        alert.show();

    }


}
