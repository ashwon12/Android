package com.example.mythread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    Handler handler2 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        //스래드 만들어주는 버튼
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BackgroundThread thread = new BackgroundThread();
                //스타트 호출하면 런이 실행
                //thread.start();

                new Thread(new Runnable() {
                    int value = 0;
                    boolean running = false;

                    @Override
                    public void run() {
                        running = true;
                        while (running) {
                            value += 1;

                            //유아이 접근
                            handler2.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText("현재 값 :" + value);
                                }
                            });

                            //예외
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                            }
                        }
                    }
                }).start();

            }
        });
    }
}
