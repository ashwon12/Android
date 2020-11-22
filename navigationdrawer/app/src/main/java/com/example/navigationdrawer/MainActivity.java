package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_chat:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frgment_layout, new ChatFragment())
                                .commit();
                        break;
                    case R.id.nav_message:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frgment_layout, new MessageFragment())
                                .commit();
                        break;
                    case R.id.nav_profile:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frgment_layout, new ProfileFragment())
                                .commit();
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this,"Share Click",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_send:
                        Toast.makeText(MainActivity.this,"Send Click",Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //    사용자가 뒤로가기를 클릭했을 때
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}