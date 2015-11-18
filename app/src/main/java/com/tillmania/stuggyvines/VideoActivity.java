package com.tillmania.stuggyvines;

import com.tillmania.stuggyvines.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.View.OnTouchListener;
import android.net.Uri;
import android.content.Intent;
/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class VideoActivity extends Activity implements OnCompletionListener,OnPreparedListener,OnTouchListener {

    private VideoView mVV;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.activity_video);

        int fileRes=0;
        Bundle e = getIntent().getExtras();
        if (e!=null) {
            fileRes = e.getInt("fileRes");
        }

        mVV = (VideoView)findViewById(R.id.myvideoview);
        mVV.setOnCompletionListener(this);
        mVV.setOnPreparedListener(this);
        mVV.setOnTouchListener(this);

        if (!playFileRes(fileRes)) return;

        mVV.start();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        int fileRes = 0;
        Bundle e = getIntent().getExtras();
        if (e != null) {
            fileRes = e.getInt("fileRes");
        }
        playFileRes(fileRes);
    }

    private boolean playFileRes(int fileRes) {
        if (fileRes==0) {
            stopPlaying();
            return false;
        } else {
            mVV.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + fileRes));
            return true;
        }
    }

    public void stopPlaying() {
        mVV.stopPlayback();
        this.finish();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        //finish();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //stopPlaying();
        mVV.seekTo(0);
        mVV.start();
        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.setLooping(false);
    }
}