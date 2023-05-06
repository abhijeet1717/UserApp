package com.example.userapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.userapp.ui.about.AboutFragment;
import com.example.userapp.ui.faculty.FacultyFragment;
import com.example.userapp.ui.gallery.GalleryFragment;
import com.example.userapp.ui.home.HomeFragment;
import com.example.userapp.ui.notice.NoticeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment = new AboutFragment();
    NoticeFragment noticeFragment = new NoticeFragment();
    FacultyFragment facultyFragment = new FacultyFragment();
    GalleryFragment galleryFragment = new GalleryFragment();


    NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private FloatingActionButton floatingActionButton;
    private NavigationView navigationView;
    HomePage homePage;
    String url = "https://chai.ml/chat/share/_bot_8cbd28a9-6e33-4620-881b-440347e25844";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,homeFragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,homeFragment).commit();
                        return true;
                    case R.id.nav_notice:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,noticeFragment).commit();
                        return true;
                    case R.id.nav_faculty:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,facultyFragment).commit();
                        return true;
                    case R.id.nav_gallery:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,galleryFragment).commit();
                        return true;
                    case R.id.nav_about:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,aboutFragment).commit();
                        return true;
                }
                return false;
            }
        });



        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this,ChassisActivity.class);
                startActivity(i);
                finish();
            }
        });



        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_video:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_ebook:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_rate:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_dev:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;


    }
}