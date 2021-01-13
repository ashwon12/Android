package com.example.myfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    MainActivity activity;

    //프래그먼트에 올라가는 메소드
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity =(MainActivity)getActivity();
    }

    //내려오는 메소드
    @Override
    public void onDetach() {
        super.onDetach();

        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //프래그먼트 안에 들어가는 최상위 뷰
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.frgment_main,container,false);

        Button button =(Button)rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(1);
            }
        });

        return rootView;
    }
}
