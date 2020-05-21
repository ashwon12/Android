package com.example.googlelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CommunityActivity extends AppCompatActivity {

    private BottomNavigationView top_navigation; //네비게이션바
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private CommunityFragment1 fragment1; // 뭐먹지 프래그먼트
    private CommunityFragment2 fragment2; // 뭐하지 프래그먼트
    private CommunityFragment3 fragment3; // 어떻게 하지 프래그먼트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);


        //네비게이션에 있는 아이콘을 눌렀을 때 나오는 프래그먼트 설정
        top_navigation = findViewById(R.id.top_navigation);
        top_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.what_eat:
                        setFragment(0);
                        break;
                    case R.id.what_do:
                        setFragment(1);
                        break;
                    case R.id.how_do:
                        setFragment(2);
                        break;
                }
                return true;
            }
        });
        fragment1 = new CommunityFragment1();
        fragment2 = new CommunityFragment2();
        fragment3 = new CommunityFragment3();
        setFragment(0); // 첫번째 프래그먼트 화면을 뭘로 띄어 줄 지

    }


    // 프래그먼트 교체가 일어나는 함수
    private void setFragment(int n){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (n){
            case 0:
                fragmentTransaction.replace(R.id.community_frame,fragment1);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.community_frame,fragment2);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.community_frame,fragment3);
                fragmentTransaction.commit();
                break;
        }
    }
}
