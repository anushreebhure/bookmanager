package com.example.bookmanagerapp.Fragment_Activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmanagerapp.Fragment_Activity.HomeActivityHelper.MyAdapter;
import com.example.bookmanagerapp.R;
import com.muddzdev.styleabletoastlibrary.StyleableToast;


public class HomeActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    int[] images;
    String[] bookNames;
    String[] bookAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        checkConnection();//Broadcast receiver

        recyclerView = findViewById(R.id.recyclerView);

        images = new int[]{R.drawable.web_design,R.drawable.android,R.drawable.js,R.drawable.r,R.drawable.matlab,R.drawable.angularjs,
        R.drawable.time,R.drawable.html_css,R.drawable.tfcs,R.drawable.java,R.drawable.think,
        R.drawable.mysql,R.drawable.python,R.drawable.iot,R.drawable.linux,R.drawable.data_science,R.drawable.micro,
        R.drawable.computer_netwrok,R.drawable.data_structures,R.drawable.cplusplus,R.drawable.nodejs,
        R.drawable.kotlin,R.drawable.visual_basic,R.drawable.artificial_intelligence,R.drawable.php,R.drawable.swift,
        R.drawable.jquery,R.drawable.machine_learning,R.drawable.os,R.drawable.django,R.drawable.cyber_security,R.drawable.history_internet,R.drawable.digital,R.drawable.ethical_hacking,R.drawable.adobe,R.drawable.sense
                ,R.drawable.margaret,R.drawable.psychologies,R.drawable.hamlet,R.drawable.pinnochio,R.drawable.german_language};
        bookNames = new String[]{"Learning Web Design","Android Programming", "JavaScript","R programming","MATLAB","AngularJS","Effective Time Management"
                ,"HTML and CSS","TFCS","Java","How Successful people Grow","MySQL"
                ,"Mastering OOP Python","Internet of Things","Linux","Data Science","8051 Microcontroller"
                ,"Computer Network","Data Structures","C++","NodeJS","Android Development with Kotlin"
        ,"Visual Basic","Artificial Intelligence","PHP","Swift","JQuery","Introduction to Machine Learning",
        "Operating Systems","Django","Cyber Security Guide","Brief History of Internet","Digital Marketing","Ethical Hacking","Adobe Photoshop","Sense and Sensibility","The Blazing World by Margaret Cavendish","PSYCHOLOGIES","Hamlet"
        ,"PINOCCHIO","German Language Kit"};
        bookAuthor = new String[]{"https://www.sccs.swarthmore.edu/users/09/leo/textbook.pdf","https://everythingcomputerscience.com/books/Android_-_a_programmers_guide.pdf",
                "https://eloquentjavascript.net/Eloquent_JavaScript.pdf"
                ,"https://cran.r-project.org/doc/contrib/Paradis-rdebuts_en.pdf"
                ,"https://www.mccormick.northwestern.edu/documents/students/undergraduate/introduction-to-matlab.pdf"
                ,"https://pepa.holla.cz/wp-content/uploads/2015/10/Beginning-AngularJS.pdf"
                ,"https://mcgraw.princeton.edu/sites/mcgraw/files/media/effective-time-management.pdf"
                ,"https://wtf.tw/ref/duckett.pdf"
                ,"http://cs.uef.fi/pages/whamalai/tepe05/tfcs.pdf"

                ,"https://www.iitk.ac.in/esc101/share/downloads/javanotes5.pdf"
                ,"https://www.readpbn.com/pdf/How-Successful-People-Grow-Sample-Pages.pdf"
                ,"https://downloads.mysql.com/docs/refman-8.0-en.pdf"
                ,"http://instructor.sdu.edu.kz/~alimzhan/Python,%201%20%D0%9A%D1%83%D1%80%D1%81/%D0%9A%D0%BD%D0%B8%D0%B3%D0%B8/Mastering%20Object-oriented%20Python.pdf"
                ,"http://cloudbus.org/papers/IoT-Book2016-C1.pdf"
                ,"https://linux-training.be/linuxfun.pdf"
                ,"https://srdas.github.io/Papers/DSA_Book.pdf"
                ,"http://ee.sharif.edu/~sakhtar3/books/8051%20Microcontrollers%20An%20Applications%20Based%20Introduction.pdf"
                ,"http://intronetworks.cs.luc.edu/current2/ComputerNetworks.pdf"
                ,"https://docs.google.com/viewer?a=v&pid=sites&srcid=cXVlc3QuZWR1LnBrfHZpZ2hpb3xneDo0YWI5YThmOWRmZDkyNzI2"
                ,"http://www.lmpt.univ-tours.fr/~volkov/C++.pdf"
                ,"https://www.vanmeegern.de/fileadmin/user_upload/PDF/Web_Development_with_Node_Express.pdf"
                ,"https://www.shabakeh-mag.com/sites/default/files/files/attachment/1397/04/1530550032.pdf"
                ,"http://cs.baylor.edu/~maurer/aida/desauto/vbasic.pdf"
                ,"https://www.cin.ufpe.br/~tfl2/artificial-intelligence-modern-approach.9780131038059.25368.pdf"
                ,"https://education.fsu.edu/wp-content/uploads/2015/04/Learning-PHP-MySQL-JavaScript-and-CSS-2nd-Edition-1.pdf"
                ,"https://carlosicaza.com/swiftbooks/SwiftLanguage.pdf"
                ,"https://www.teamwerx.org/wp-content/uploads/2017/10/Web-Development-with-jQuery.pdf"
                ,"https://alex.smola.org/drafts/thebook.pdf"
                ,"https://it.bmc.uu.se/andlov/dev/books/Operating%20System%20Concepts%206ed.pdf"
                ,"http://gsl-archive.mit.edu/media/programs/mexico-summer-2014/materials/djangobook.pdf"
                ,"https://www.datto.com/resource-downloads/cyberlive-ebook.pdf"
                ,"https://www.internetsociety.org/wp-content/uploads/2017/09/ISOC-History-of-the-Internet_1997.pdf"
                ,"https://digitalfireflymarketing.com/wp-content/uploads/2017/02/Big-Book-of-Digital-Marketing.pdf"
                ,"https://repo.zenk-security.com/Magazine%20E-book/EN-Ethical%20Hacking.pdf"
                ,"https://helpx.adobe.com/pdf/photoshop_reference.pdf"
                ,"https://www.planetebook.com/free-ebooks/sense-and-sensibility.pdf"
                ,"https://www.globalgreyebooks.com/read-online/blazing-world/read-online.html"
                ,"http://www.gutenberg.org/files/48485/48485-h/48485-h.htm"
                ,"https://www.williamshakespeare.net/ebook-hamlet.jsp"
                ,"http://www.gutenberg.org/files/16865/16865-h/16865-h.htm"
                ,"https://www.languagecoursesuk.co.uk/wp-content/uploads/2016/06/Booklet-Language-Kit-German.pdf"
                };



        //LinearLayoutManager need to be used whenever we are using Recycler View
        //set the items in vertical orientation
        //false for reverse layout (reverse items in the list)

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //pass the items through constructor in MyAdapter class
        MyAdapter myAdapter = new MyAdapter(HomeActivity.this, images, bookNames, bookAuthor);
        recyclerView.setAdapter(myAdapter);
    }

    public void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                StyleableToast.makeText(this, "Wifi Enabled", R.style.exampleToast).show();
            } if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                StyleableToast.makeText(this, "Data Network Enabled", R.style.exampleToast).show();
            }
        }
        else{
            StyleableToast.makeText(this, "No Internet Connection", R.style.exampleToast).show();
        }
    }
    private void layoutAnimation(RecyclerView recyclerView){
        Context context=recyclerView.getContext();
        LayoutAnimationController layoutAnimationController=
                AnimationUtils.loadLayoutAnimation(context,R.anim.layout_down_to_up);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

}
