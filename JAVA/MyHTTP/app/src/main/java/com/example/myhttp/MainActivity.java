package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    String urlStr;

    Handler handler= new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =(EditText)findViewById(R.id.editText);
        textView= (TextView)findViewById(R.id.textView);

        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlStr = editText.getText().toString(); //사용자가 입력한 정보가 보인다.
                RequestThread thread = new RequestThread();
                thread.start();
             }
        });
    }

    class RequestThread extends Thread{
            public void  run(){

                try{
                    URL url = new URL(urlStr);

                    HttpURLConnection conn =(HttpURLConnection) url.openConnection();
                    if(conn != null){
                        conn.setConnectTimeout(10000);//10초동안 기다려싿가 응답없으면 끝남
                        conn.setRequestMethod("GET");
                        conn.setDoInput(true); //서버로 받는 것
                        conn.setDoOutput(true);// 서버로 보내는 것

                        int resCode =conn.getResponseCode();

                        //if(resCode ==HttpURLConnection.HTTP_OK)

                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String line = null;

                        while (true){
                            line = reader.readLine();
                            if(line == null){
                                break;
                            }

                            println(line);
                        }

                        reader.close();
                        conn.disconnect();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
    }

    public void println(final String data){
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(data+"\n"); //append 추가하는 거
            }
        });

    }
}
