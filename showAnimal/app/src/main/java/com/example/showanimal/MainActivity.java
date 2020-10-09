package com.example.showanimal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private Button button;
    private ImageView img;
    private View dialogview,toastview;
    private TextView toast_tv;
    private AlertDialog.Builder dlg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Exercise7_6");

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedButton = (RadioButton) findViewById(id);
        dialogview=(View)View.inflate(MainActivity.this,R.layout.dialog,null);
        img=(ImageView)dialogview.findViewById(R.id.imageView);
        dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle(selectedButton.getText().toString());
        dlg.setIcon(R.drawable.ic_baseline_group_24);
        if(selectedButton.getText().toString().equals("강아지")){
            img.setImageResource(R.drawable.dog);
        }else if(selectedButton.getText().toString().equals("고양이")){
            img.setImageResource(R.drawable.cat);
        }else if(selectedButton.getText().toString().equals("토끼")){
            img.setImageResource(R.drawable.rabbit);
        }
        dlg.setView(dialogview);
        dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast toast = new Toast(MainActivity.this);
                toastview=(View)View.inflate(MainActivity.this,R.layout.toast,null);
                toast_tv=(TextView)toastview.findViewById(R.id.toast_tv);
                toast_tv.setText("대화상자를 닫았습니다.");
                toast.setView(toastview);
                toast.show();
            }
        });
        dlg.show();
    }
}