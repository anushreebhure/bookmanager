package com.example.bookmanagerapp.Fragment_Activity;


import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmanagerapp.Fragment_Activity.MyBookActivityHelper.DatabaseHelper;
import com.example.bookmanagerapp.R;

public class MyBookActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btn_insert_data,btn_dataView,btn_updateData,btn_deleteData,btn_save;
    EditText text_BookName,text_AuthorName,text_Publisher,text_ID;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_BOOKNAME="name";
    private static final String KEY_AUTHOR_NAME="author";


    private String name;
    private String author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybook);

        //Animation
        RelativeLayout relativeLayout=findViewById(R.id.layout);
        AnimationDrawable animationDrawable=(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        myDb = new DatabaseHelper(this);
        btn_insert_data=(Button) findViewById(R.id.btn_insert);

        text_BookName=(EditText) findViewById(R.id.editTextName);
        text_AuthorName=(EditText) findViewById(R.id.editTextSurName);
        text_Publisher=(EditText) findViewById(R.id.editTextMarks);
        btn_dataView=(Button) findViewById(R.id.btn_ViewAll);

        btn_updateData=(Button) findViewById(R.id.btn_Update);
        text_ID=(EditText)findViewById(R.id.editTextID);

        btn_deleteData=(Button) findViewById(R.id.btn_Delete);
        btn_save=(Button)findViewById(R.id.btn_save);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_BOOKNAME,text_BookName.getText().toString());
                editor.putString(KEY_AUTHOR_NAME,text_AuthorName.getText().toString());
                Toast.makeText(MyBookActivity.this,"Data saved",Toast.LENGTH_SHORT).show();
                editor.apply();
            }
        });
        loadData();
        updateViews();


        btn_insert_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isinserted =  myDb.insertData(text_BookName.getText().toString(),
                        text_AuthorName.getText().toString(),
                        text_Publisher.getText().toString());

                if(isinserted == true){
                    Toast.makeText(MyBookActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MyBookActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
            //to view all the data
        btn_dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cur = myDb.getAllData();

                if(cur.getCount() == 0){
                    showMessage("Error","No Data Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (cur.moveToNext()){

                    buffer.append("Acc No: "+ cur.getString(0)+"\n");
                    buffer.append("Book Name: "+ cur.getString(1)+"\n");
                    buffer.append("Author Name: "+ cur.getString(2)+"\n");
                    buffer.append("Publisher: "+ cur.getString(3)+"\n");

                }

                showMessage("Data",buffer.toString());

            }
        });

        btn_updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isUpdate= myDb.updateData(text_ID.getText().toString(),text_BookName.getText().toString(),
                        text_AuthorName.getText().toString(),text_Publisher.getText().toString());

                if(isUpdate == true){
                    Toast.makeText(MyBookActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MyBookActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deletedRow = myDb.deleteData(text_ID.getText().toString());

                if(deletedRow>0){
                    Toast.makeText(MyBookActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MyBookActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
    //shared pref for bookname and authorname
    public void loadData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        name=sharedPreferences.getString(KEY_BOOKNAME,"");
        author=sharedPreferences.getString(KEY_AUTHOR_NAME,"");

    }
    //only bookname and author name can be updated
public void updateViews(){
        text_BookName.setText(name);
        text_AuthorName.setText(author);

}

//shows dialog pop up after every query is performed
    public void showMessage(String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}
