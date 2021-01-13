package com.example.votemovie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    public String[] movieTitle = new String[]{"써니","완득이", "괴물", "라디오스타", "비열한 거리", "왕의 남자", "아일랜드", "웰컴투 동막골", "헬보이", "백 투더 퓨쳐"};
    myDBHelper helper;
    SQLiteControl sqLiteControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화 투표 앱");

        //DB 생성
        helper= new myDBHelper(MainActivity.this);
        sqLiteControl = new SQLiteControl(helper);
        dbInsert();

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
                    case R.id.vote_movie:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frgment_layout, new VoteFragment())
                                .commit();
                        break;
                    case R.id.vote_result:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frgment_layout, new ResultFragment(helper))
                                .commit();
                        break;
                    case R.id.vote_reset:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frgment_layout, new ResetFragment())
                                .commit();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    public void dbInsert() {
        for (int i = 0; i <movieTitle.length ; i++) {
            Log.i("디비", "dbInsert:"+movieTitle[i]);
            sqLiteControl.insert(movieTitle[i],1);
        }
        Log.d("디비삽입", "dbInsert: 넣었다! ");
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

    //사용자가 뒤로가기를 클릭했을 때
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}