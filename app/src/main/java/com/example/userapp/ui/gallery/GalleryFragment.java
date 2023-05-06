package com.example.userapp.ui.gallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.userapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    RecyclerView recyclerView1 , recyclerView2;
    GalleryAdapter adapter;
//    DatabaseReference reference ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView1 = view.findViewById(R.id.convocation);
        recyclerView2 = view.findViewById(R.id.others);

        getConvocation();
        getOthers();
        return view;
    }

    private void getConvocation() {
    }
    private void getOthers() {
    }
}