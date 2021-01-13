package com.example.myintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //메뉴 액티비티를 띄어주는 인텐트
                Intent intent =  new Intent(getApplicationContext(),MenuActivity.class);
                //시스템으로 인텐트를 전달하면서 화면을 띄어준다!
                startActivityForResult(intent,101);
            }
        });
    }

    //응답을 받을 메소드 작성

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==101){
            String name= data.getStringExtra("name");
            Toast.makeText(getApplicationContext(),"메뉴화면으로부터 응답:"+ name ,Toast.LENGTH_LONG).show();

        }
    }
}
