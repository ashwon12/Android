package com.example.voteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();
        int[] voteResult;
        String[] imageNames;
        if(extras != null){
            voteResult =extras.getIntArray("VoteCount");
            imageNames = extras.getStringArray("ImageNames");

            TextView tv[] = new TextView[imageNames.length];
            RatingBar rbar[] = new RatingBar[imageNames.length];

            Integer tvID[]= {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
            Integer rbarID[] = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

            for (int i = 0; i < imageNames.length ; i++) {
                tv[i]=(TextView)findViewById(tvID[i]);
                rbar[i]=(RatingBar)findViewById(rbarID[i]);
            }

            for (int i = 0; i < imageNames.length ; i++) {
                tv[i].setText(imageNames[i]);
                rbar[i].setRating(voteResult[i]);
            }
        }

        Button btnResult= (Button)findViewById(R.id.btnReturn);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}