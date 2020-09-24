package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1,btn2,btn3,btn4,btn5;
    private EditText et1,et2;
    private TextView result;

    double num1,num2,cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //아이디 값 찾아주기
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        result=(TextView)findViewById(R.id.result);

        //버튼 리스너
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (et1.getText().toString().equals("") && et2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
        } else {
            num1 = Double.parseDouble(et1.getText().toString());
            num2 = Double.parseDouble(et2.getText().toString());
            switch (view.getId()) {
                case R.id.btn1:
                    cal = num1 + num2;
                    break;
                case R.id.btn2:
                    cal = num1 - num2;
                    break;
                case R.id.btn3:
                    cal = num1 * num2;
                    break;
                case R.id.btn4:
                    if (num2 == 0) {
                        Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        result.setText("");
                        return;
                    } else {
                        cal = num1 / num2;
                        break;
                    }
                case R.id.btn5:
                    if (num2 == 0) {
                        Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        result.setText("");
                        return;
                    } else {
                        cal = num1 % num2;
                        break;
                    }
            }
            result.setText("계산결과 : " + String.format("%.2f", cal));
        }
    }
}