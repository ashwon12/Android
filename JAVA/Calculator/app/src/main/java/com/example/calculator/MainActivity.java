package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private EditText et1,et2;
    private TextView result;
    private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //아이디 값 찾아주기
        btn=(Button)findViewById(R.id.btn);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        rg=(RadioGroup)findViewById(R.id.rg);
        result=(TextView)findViewById(R.id.result);

        //버튼 리스너
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {


        if (et1.getText().toString().equals("") || et2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
        }else {
            int num1=Integer.parseInt(et1.getText().toString());
            int num2=Integer.parseInt(et2.getText().toString());

            int id = rg.getCheckedRadioButtonId();
            if(id == R.id.rb1) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                intent.putExtra("num1",num1);
                intent.putExtra("num2",num2);
                startActivityForResult(intent,0);
            }else if(id == R.id.rb2) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                intent.putExtra("num1",num1);
                intent.putExtra("num2",num2);
                startActivityForResult(intent,0);
            }else if(id == R.id.rb3) {
                Intent intent= new Intent(MainActivity.this,MulActivity.class);
                intent.putExtra("num1",num1);
                intent.putExtra("num2",num2);
                startActivityForResult(intent,0);
            }else{
                Toast.makeText(MainActivity.this,"버튼을 선택해주세요",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int resultValue = data.getIntExtra("resultVal", 0);
            result.setText(String.valueOf(resultValue));
        }
    }
}