package com.tillmania.stuggyvines;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sean on 18/11/15.
 */
public class AshtonImageAdapter extends BaseAdapter {

    private Context mContext;
    private static LayoutInflater inflater = null;
    private int[] sounds = {
            R.raw.ash_aussie,
            R.raw.ash_bumstuff,
            R.raw.ash_burp,
            R.raw.ash_cunt,
            R.raw.ash_fattyfuck,
            R.raw.ash_gonnamakeyoubleed,
            R.raw.ash_midwipe,
            R.raw.ash_nodont,
            R.raw.ash_ohno,
            R.raw.ash_rejection,
            R.raw.ash_uptowngirl,
            R.raw.ash_wankkingfuck,


    };
    private String[] soundTitles = {
            "Aussie",
            "Bum Stuff",
            "Burp",
            "C**t",
            "Fatty Fuck",
            "Make You Bleed",
            "Mid Wipe",
            "No Dont!",
            "Oh No!",
            "Rejection",
            "Uptown Girl",
            "Wanking Fuck",


    };
    private MediaPlayer mp;

    public AshtonImageAdapter(Context c) {
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
        holder.img.setImageResource(R.drawable.ashtonsoundglyph);
        holder.tv.setText(soundTitles[position]);
        //holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("FUCK", "FUCK");
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(mContext, sounds[position]);
                mp.start();

            }
        });


        return rowView;
    }
}