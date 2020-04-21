package com.example.myserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerThread thread = new ServerThread();
                thread.start();
            }
        });
    }

    class ServerThread extends Thread{
        public void run(){
            int port = 5001;
            try{
                ServerSocket server = new ServerSocket(port);
                Log.d("ServerThread","서버가 실행됨."); //5001 포트로 대기

                while(true){
                    Socket socket = server.accept();

                    //들어오는 객체 inputstream
                    ObjectInputStream inputStream =  new ObjectInputStream( socket.getInputStream());
                    Object input = inputStream.readObject(); //클라이언트에서 들어온 객체 읽기
                    Log.d("ServerThread","input:"+input);

                    //보내는 객체 outputstream
                    ObjectOutputStream outputStream =new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(input +"from sever."); //클라이언트에 보내는 객체 작성
                    outputStream.flush(); //아웃풋 스트림에 꼭 해주3
                    Log.d("ServerThread","output 보냄.");

                    socket.close(); // 연결유지가 필요가 없을 때 끊어주3, 웬만하면 닫아주3
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
