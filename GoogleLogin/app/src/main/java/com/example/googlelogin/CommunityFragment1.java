package com.example.googlelogin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommunityFragment1 extends Fragment {

    private View view;

    //리사이클러뷰
    private RecyclerView recycler_what_eat;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<bringData> arrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.community_fragment1,container,false);

        recycler_what_eat = (RecyclerView)view.findViewById(R.id.recycler_what_eat);
        recycler_what_eat.setHasFixedSize(true);
        adapter = new CustomAdapter(arrayList);

        layoutManager = new LinearLayoutManager(getActivity());
        recycler_what_eat.setLayoutManager(layoutManager);
        recycler_what_eat.scrollToPosition(0);
        recycler_what_eat.setItemAnimator(new DefaultItemAnimator());
        recycler_what_eat.setAdapter(adapter);

         return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //prepareData();
    }

    private void prepareData() {
        //arrayList.add(new bringData("백종원 꿀팁 알려줌","ashwon12","마땅히 할 찌개요리가 없을 때 생각나는 참치김치찌개 김치만 넣고 끓이는 것 보다 훨씬 깊은 맛이 나 자주 해먹는 참치김치찌개에요"));

    }


}
