package com.example.imageviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.function.ToDoubleBiFunction;

public class MainActivity extends AppCompatActivity {
    Button btn_prev,btn_next;
    myPictureView myPictureView;
    int cutNum;
    File[] imageFiles;
    String imageName;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE},1000);

        btn_next = (Button)findViewById(R.id.btn_next);
        btn_prev=(Button)findViewById(R.id.btn_prev);
        myPictureView =(myPictureView)findViewById(R.id.myPictureView1);
        textView=(TextView)findViewById(R.id.textView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1000:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    imageFiles = new File(Environment.getExternalStorageDirectory().getPath()+"/Pictures").listFiles();
                    cutNum=0;
                    imageName = imageFiles[cutNum].toString();
                    myPictureView.imagePath = imageName;
                    myPictureView.invalidate();

                    btn_prev.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(cutNum <=0 ) {
                                cutNum=imageFiles.length-1;
                            }else{
                                cutNum--;
                            }
                            textView.setText((cutNum+1)+"/10");
                            imageName=imageFiles[cutNum].toString();
                            myPictureView.imagePath=imageName;
                            myPictureView.invalidate();
                        }
                    });

                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(cutNum >= imageFiles.length-1){

                                cutNum=0;
                            }else{
                                cutNum++;
                            }
                            textView.setText((cutNum+1)+"/10");
                            imageName=imageFiles[cutNum].toString();
                            myPictureView.imagePath=imageName;
                            myPictureView.invalidate();
                        }
                    });
                }
                else{
                Toast.makeText(MainActivity.this, "permission을 허용해주세요", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,new String[]
                        {Manifest.permission.WRITE_EXTERNAL_STORAGE},1000);
                break;
            }
        }
    }

}

