package com.example.userapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
//import androidx.slidingpanelayout.widget.SlidingPaneLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.userapp.HomePage;
import com.example.userapp.R;
//import com.google.android.material.progressindicator.LinearProgressIndicator;


public class HomeFragment extends Fragment {

//private SlidingPaneLayout slidingPaneLayout;
private ImageView map;
ImageView fb,in,web;
private VideoView videoView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        MediaController mc= new MediaController(getActivity());


        videoView = (VideoView)view.findViewById(R.id.videoView);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.merivideo;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mc);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        web = view.findViewById(R.id.web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.rkgit.edu.in/contactus/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        in = view.findViewById(R.id.instagram);
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/rkgit_/?hl=en";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        fb = view.findViewById(R.id.facebook);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com/rkgitgzb/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        return view;

    }


    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Rkgit College Ghaizabad");
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
    }
}