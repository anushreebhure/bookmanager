package com.example.bookmanagerapp.Fragment_Activity.HomeActivityHelper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmanagerapp.R;


//MyAdapter class to inflate the layout and handle all those stuff (Recycler View)
//Adapter manages the items inside the Recycler View

public class MyAdapter extends RecyclerView.Adapter<PlaceViewHolder> {
    private Context context;
   private int[] images;
    private String[] bookNames;
    private String[] bookAuthor;

    //Constructor
    public MyAdapter(Context context, int[] images, String[] bookNames, String[] bookAuthor){
        this.context=context;
        this.images=images;
        this.bookNames=bookNames;
        this.bookAuthor=bookAuthor;
    }
    @NonNull
    @Override

    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row,parent,false);
        return new PlaceViewHolder(view);
    }

    @Override
    //access the views inside PlaceViewHolder class in the below method

    public void onBindViewHolder(@NonNull final PlaceViewHolder holder, int position) {
        holder.bookName.setText(bookNames[position]);//String array(use [position])
        holder.book.setImageResource(images[position]);
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Let's learn " + bookNames[holder.getAdapterPosition()]+
                        "\n Here is the link: " + bookAuthor[holder.getAdapterPosition()]);
                intent.setType("text/plain");

                //holder.getAdapterPosition() to  get the exact position of the item

                context.startActivity(Intent.createChooser(intent,"Send To"));

            }
        });
        holder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(bookAuthor[holder.getAdapterPosition()]));
                //to parse the url
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}

//define the views that we created inside Recycler view
class PlaceViewHolder extends RecyclerView.ViewHolder{
    ImageView book;
    TextView bookName;
    Button share;
    Button visit;

    //Constructor
    public PlaceViewHolder(@NonNull View itemView) {
        super(itemView);

        book=itemView.findViewById(R.id.ivBook);
        bookName= itemView.findViewById(R.id.tvBookName);
        share=itemView.findViewById(R.id.btnShare);
        visit= itemView.findViewById(R.id.btnVisit);
    }
}
