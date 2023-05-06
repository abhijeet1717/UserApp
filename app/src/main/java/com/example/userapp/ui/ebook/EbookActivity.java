package com.example.userapp.ui.ebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.userapp.R;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<EbookData> list;
    private EbookAdapter adapter;

    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        recyclerView = findViewById(R.id.ebookRecycler);

        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
        linearLayout = findViewById(R.id.shimmer_layout);

        getData();
    }

    private void getData() {
       shimmerFrameLayout.stopShimmer();
       linearLayout.setVisibility(View.GONE);
    }
////    @Override
////    protected void OnPause(){
//        shimmerFrameLayout.stopShimmer();
//        super.onPause();
//    }
}