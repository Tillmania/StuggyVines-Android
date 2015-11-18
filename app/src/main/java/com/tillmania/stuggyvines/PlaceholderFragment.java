package com.tillmania.stuggyvines;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Sean on 18/11/15.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);

        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }
    public void playVideo(String resourceName) {
        Intent videoPlaybackActivity = new Intent(this.getActivity(), VideoActivity.class);
        int res=this.getResources().getIdentifier(resourceName, "raw", this.getActivity().getPackageName());
        videoPlaybackActivity.putExtra("fileRes", res);
        startActivity(videoPlaybackActivity);
    }
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        GridView gridview = (GridView) rootView.findViewById(R.id.gridView);

        //GridView gridview = (GridView) findViewById(R.id.gridView);
        if(getArguments().get(ARG_SECTION_NUMBER) == 1) {
            gridview.setAdapter(new ImageAdapter(getActivity()));

        }
        else if(getArguments().get(ARG_SECTION_NUMBER) == 2) {
            gridview.setAdapter(new AshtonImageAdapter(getActivity()));
            ImageView img= (ImageView) rootView.findViewById(R.id.imageView);
            img.setImageResource(R.drawable.ashtonbannersource);
        }
        else if(getArguments().get(ARG_SECTION_NUMBER) == 3) {
            MouthboardImageAdapter newImageAdapter = new MouthboardImageAdapter(getActivity());
            gridview.setAdapter(newImageAdapter);

            newImageAdapter.mainView =this;
            ImageView img= (ImageView) rootView.findViewById(R.id.imageView);
            img.setImageResource(R.drawable.mouthboardbanner);

//                VideoView vid= (VideoView) rootView.findViewById(R.id.videoView);
//                String path = "android.resource://com.tillmania.stuggyvines/"+R.raw.mouthboard_instyle;
//                vid.setVideoPath(path);
//
//                vid.setMediaController(new MediaController(rootView.getContext()));
//                vid.start();
//                vid.requestFocus();
        }

        return rootView;
    }
}