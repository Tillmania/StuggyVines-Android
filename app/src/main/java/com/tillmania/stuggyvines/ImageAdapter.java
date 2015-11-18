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
 * Created by Sean on 15/05/15.
 */
public class ImageAdapter extends BaseAdapter {
    public String currentSection;
    private Context mContext;
    private static LayoutInflater inflater = null;
    private int[] sounds = {R.raw.ashton1,
            R.raw.ashton2,
            R.raw.bangdirtgone,
            R.raw.boomclap,
            R.raw.cantseeanything,
            R.raw.croissantbellend,
            R.raw.dontlikewhoiam,
            R.raw.englanddusting,
            R.raw.englandgel,
            R.raw.englishblowdryer,
            R.raw.exquisitecowshit,
            R.raw.fuckinggrey,
            R.raw.high,
            R.raw.holyshit,
            R.raw.homiebizzles,
            R.raw.ifitthecriteria,
            R.raw.imaprettyprincess,
            R.raw.instyle1,
            R.raw.instyle2,
            R.raw.instyle3,
            R.raw.jesuiscroissant1,
            R.raw.jesuiscroissant2,
            R.raw.jesuiscroissant3,
            R.raw.jesuiscroissant4,
            R.raw.laugh1,
            R.raw.laugh2,
            R.raw.laugh3,
            R.raw.laugh4,
            R.raw.laugh5,
            R.raw.laugh6,
            R.raw.mooseloose,
            R.raw.ninetofive,
            R.raw.nowimamonkey,
            R.raw.nowimawizard,
            R.raw.pooinmyshoe,
            R.raw.pooonit,
            R.raw.poshfoods,
            R.raw.prematurelykangaroo,
            R.raw.pugforeskin,
            R.raw.pussy1,
            R.raw.pussy2,
            R.raw.pussy3,
            R.raw.pussy4,
            R.raw.raspberries1,
            R.raw.raspberries2,
            R.raw.raspberries3,
            R.raw.rightinthekiwis,
            R.raw.soglorious,
            R.raw.spreadthebubblyjoy,
            R.raw.summertime,
            R.raw.tenderness1,
            R.raw.tenderness2,
            R.raw.tescos,
            R.raw.thetittydivider,
            R.raw.thisisoutrageous,
            R.raw.toofuckinghot,
            R.raw.wankingwithbutter,
            R.raw.weverunoutof,
            R.raw.wherespussy,
            R.raw.yak1,
            R.raw.yak2,
            R.raw.yak3,
            R.raw.yak4,
            R.raw.yak5,
            R.raw.yak6,
            R.raw.youreapussy
    };
    private String[] soundTitles = {"Ashton 1",
            "Ashton 2",
            "Bang",
            "Boom, Clap",
            "Cant See",
            "Croissant Bellend",
            "Who I am",
            "England Dusting",
            "England Gel",
            "English Blowdrier",
            "Exquisite Cowshit",
            "Fucking Grey",
            "High",
            "Holy Shit",
            "Homebizzles",
            "I Fit",
            "Im a Pretty",
            "In Style 1",
            "In Style 2",
            "In Style 3",
            "Je Suis Croissant 1",
            "Je Suis Croissant 2",
            "Je Suis Croissant 3",
            "Je Suis Croissant 4",
            "Laugh 1",
            "Laugh 2",
            "Laugh 3",
            "Laugh 4",
            "Laugh 5",
            "Laugh 6",
            "Moose Loose",
            "Nine 2 Five",
            "Now Im a Monkey",
            "Now Im a Wizard",
            "Poo in my Shoe",
            "Poo on it",
            "Posh Foods",
            "Premature",
            "Pug Foreskin",
            "Pussy 1",
            "Pussy 2",
            "Pussy 3",
            "Pussy 4",
            "Raspberries 1",
            "Raspberries 2",
            "Raspberries 3",
            "Right in the Kiwis",
            "So Glorious",
            "Spread the Joy",
            "Summertime",
            "Tenderness 1",
            "Tenderness 2",
            "Tescos",
            "The Divider",
            "This is Outrageous",
            "Too Hot",
            "Wanking",
            "We've Run Out!",
            "Wheres Pussy",
            "Yak 1",
            "Yak 2",
            "Yak 3",
            "Yak 4",
            "Yak 5",
            "Yak 6",
            "You're a Pussy",
    };
    private MediaPlayer mp;

    public ImageAdapter(Context c) {
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