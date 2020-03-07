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
    Button button2;

    //int value =0;

    ValueHandler handler = new ValueHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView)findViewById(R.id.textView);

        //스래드 만들어주는 버튼
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundThread thread = new BackgroundThread();

                //스타트 호출하면 런이 실행
                thread.start();

            }
        });

        button2 =(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }


    class BackgroundThread extends Thread{
        int value =0;
        boolean running = false;

        public void run(){
            running = true;
            while (running){
                value+=1;

                /* 여기에 작성하면 에러가 발생함 -> 핸들러 사용해야 함
                textView.setText("현재 값:"+value);
                 */
                Message message = handler.obtainMessage();
                Bundle bundle=new Bundle();
                bundle.putInt("value",value);
                message.setData(bundle);
                handler.sendMessage(message);

                //예외
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }

        }
    }

    
    //핸들러 유아이 직접 접근 가능
    class ValueHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {

            //핸들메세지 오버라이딩
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            textView.setText("현재 값:"+value);
        }
    }
}
