package com.example.event;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //텍스트 뷰를 찾는다.내용을 출력할 곳
        textView =(TextView) findViewById(R.id.textView);

        //첫번쨰 뷰에 이벤트 처리
        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            //액션으로 나누어
            public boolean onTouch(View v, MotionEvent event){
                int action = event.getAction(); //각각의 상태를 구분할 수 있음

                float curX = event.getX();
                float curY = event.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    println("손가락 눌렸음 : "+curX+","+curY);
                }else if(action == MotionEvent.ACTION_MOVE){
                    println("손가락 움직임 : "+curX+","+curY);
                }else if(action == MotionEvent.ACTION_UP){
                    println("손가락 떼졌음 : "+curX+","+curY);
                }
                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown() 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress() 호출됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp() 호출됨");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll() 호출됨" +distanceX + distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress() 호출됨");

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling() 호출됨"+velocityX+","+velocityY);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener((new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        }));
    }

    //키가 눌렸을 때 메소드 호출
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this,"시스템 벡 버튼 눌림",Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    //append를 이용해서 데이터 전달, data+줄바꿈이 출력되는 함수
    public void  println(String data){
        textView.append(data +"\n");
    }
}
