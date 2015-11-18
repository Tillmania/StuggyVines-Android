package com.tillmania.stuggyvines;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.IOException;

/**
 * Created by Sean on 18/11/15.
 */
public class MouthboardImageAdapter extends BaseAdapter {

    private Context mContext;
    private static LayoutInflater inflater = null;
    private int[] sounds = {
            R.raw.test,
            R.raw.yak2,
            R.raw.yak3,
            R.raw.yak4,
            R.raw.yak5,
            R.raw.yak6,

    };
    private String[] soundTitles = {
            "Yak 1",
            "Yak 2",
            "Yak 3",
            "Yak 4",
            "Yak 5",
            "Yak 6",

    };
    public MediaPlayer mp;
    public PlaceholderFragment mainView;
    public MouthboardImageAdapter(Context c) {
        mContext = c;

        inflater = (LayoutInflater) mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    public int getCount() {
        return sounds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub


        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.griditem, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textView1);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.img.setImageResource(R.drawable.mbglyph);
        holder.tv.setText(soundTitles[position]);
        //holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainView.playVideo("mouthboard_instyle");
//                if (mp != null) {
//                    mp.stop();
//                    mp.release();
//                    mp = null;
//                }
//                VideoView vp = (VideoView)mainView.findViewById(R.id.myvideoview);
//                vp.setVisibility(View.VISIBLE);
//                String path = "android.resource://com.tillmania.stuggyvines/"+R.raw.mouthboard_instyle;
//                vp.setVideoPath(path);
//
//                //vp.setMediaController(new MediaController(mainView.getContext()));
//                vp.start();
//                vp.requestFocus();



            }
        });


        return rowView;
    }
}