package com.example.mylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SigerItemVIew extends LinearLayout {

    TextView textView;
    TextView textView2;

   //뷰 정의할 떄 필수 생성자 2개
    public SigerItemVIew(Context context) {
        super(context);

        init(context);
    }

    public SigerItemVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    //초기화를 위한 메소드
    private void init(Context context){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate((R.layout.singer_item),this,true);

        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
    }

    //데이터 설정 할 때
    public  void setName(String name){
        textView.setText(name);
    }

    public  void setNumber(String number){
        textView2.setText(number);
    }
}
