package com.example.voteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("명화 선호도 투표");

        final int VoteCount[] = new int[9];
        for (int i = 0; i <VoteCount.length ; i++) {
            VoteCount[i]=0;
        }
        ImageView image[]= new ImageView[9];
        Integer imageID[]= {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9};
        final String imageName[] = {"독서하는 소녀","꽃장식 모자 소녀","부채를 든 소녀","이레느깡 단 베르망","잠자는 소녀" ,
                "테라스의 두 자매","피아노 레슨","피아노 앞의 소녀들","해변에서"};
        for (int i = 0; i <imageID.length ; i++) {
            final int index;
            index = i;

            image[index]=(ImageView)findViewById(imageID[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VoteCount[index]++;
                    Toast.makeText(MainActivity.this,imageName[index]+": 총"+VoteCount[index]+"표",Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnResult =(Button)findViewById(R.id.btn_result);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("VoteCount",VoteCount);
                intent.putExtra("ImageNames",imageName);
                startActivity(intent);
            }
        });
    }
}