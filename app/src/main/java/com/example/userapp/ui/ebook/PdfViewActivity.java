package com.example.userapp.ui.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.userapp.R;

public class PdfViewActivity extends AppCompatActivity {

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        url = getIntent().getStringExtra("pdfUrl");

    }
}