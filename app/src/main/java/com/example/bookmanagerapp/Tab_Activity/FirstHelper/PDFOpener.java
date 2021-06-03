package com.example.bookmanagerapp.Tab_Activity.FirstHelper;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmanagerapp.R;
import com.github.barteksc.pdfviewer.PDFView;
//code for opening specified book PDF
public class PDFOpener extends AppCompatActivity {
PDFView myPDFViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_opener);

        myPDFViewer=(PDFView)findViewById(R.id.pdfviewer);
        String getItem=getIntent().getStringExtra("pdfFileName");//pdfFileName is key that is retrieved here after passing at First.java
        //load() is used to show the pdf file after selecting  the book name
        //app->new->folder->assets folder just copy paste the pdf in res folder
        if(getItem.equals("HTML and CSS Crash Course")){
            myPDFViewer.fromAsset("Coding Interview Ninja_ 50 coding questions with Java solutions to practice for your coding interview. ( PDFDrive.com ).pdf").load();
        }
        if(getItem.equals("Coding Interview Ninja_50 Coding Questions")){
            myPDFViewer.fromAsset("Coding Interview Ninja_ 50 coding questions with Java solutions to practice for your coding interview. ( PDFDrive.com ).pdf").load();
        }
        if(getItem.equals("Javascript")){
            myPDFViewer.fromAsset("JavaScript_compressed.pdf").load();
        }
        if(getItem.equals("LINUX Interview Questions")){
            myPDFViewer.fromAsset("Linux Interview Questions_ Open Source Linux Operating Systems Interview Questions, Anwers, and Explanations   ( PDFDrive.com ).pdf").load();
        }
        if(getItem.equals("Resisting Happiness")){
            myPDFViewer.fromAsset("Resisting Happiness_compressed.pdf").load();

        }

    }
}