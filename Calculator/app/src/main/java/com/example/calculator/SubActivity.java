package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private Integer num1 = null;
    private Integer num2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        setTitle("빼기");

        TextView tv_result = (TextView)findViewById(R.id.et_result);

        /* 값 받아오기 */
        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();
        if(extras !=null){
            num1 = extras.getInt("num1");
            num2 = extras.getInt("num2");
            tv_result.setText(num1 + "-" + num2 +"="+(num1-num2));
        }


        Button btn_result = (Button)findViewById(R.id.btn_return);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("resultVal",(num1-num2));
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }
}