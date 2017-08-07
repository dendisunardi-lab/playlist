package com.dendi.playlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.R.attr.start;

/**
 * Created by dendisunardi on 8/2/17.
 */

public class CustomAdapter extends ArrayAdapter<Song> {
    ArrayList<Song> songs;
    Context context;
    int resource;

    public CustomAdapter(Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.songs = songs;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null ){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list, null, true);
        }

        Song song = getItem(position);
        String newArtist = song.getArtist();
        String newTitle = song.getTitle();
        String newImage = song.getImage();

        ImageView imageView = (ImageView)convertView.findViewById(R.id.android_imv);
        Picasso.with(context).load(newImage).into(imageView);

        TextView artistText = (TextView)convertView.findViewById(R.id.tv_artist);
        artistText.setText(newArtist);
        TextView titleText = (TextView)convertView.findViewById(R.id.tv_desc);
        titleText.setText(newTitle);

//        convertView.setOnClickListener(new View.OnClickListener(){
//
////            Song songs = new Song();
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CustomAdapter.this, DetailPage.class);
//                startActivityForResult(intent);
//                System.out.println("hallo...........");
//            }
//        });

        return convertView;


    }

//    private void openDetailActivity(String name, int image) {
//        Intent intent = new Intent(c, DetailPage.class);
//
//        //pack data
//        intent.putExtra()
//    }
}
