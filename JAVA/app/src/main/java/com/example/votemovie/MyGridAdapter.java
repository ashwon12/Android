package com.example.votemovie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MyGridAdapter extends BaseAdapter {
    Context context;
    private View dialogView;
    public String[] movieTitle = new String[]{"써니", "완득이", "괴물", "라디오스타", "비열한 거리", "왕의 남자", "아일랜드", "웰컴투 동막골", "헬보이", "백 투더 퓨쳐"};
    myDBHelper helper;
    SQLiteControl sqLiteControl;
    SQLiteDatabase sqLiteDatabase;

    public MyGridAdapter(Context c){
        context=c;
    }

    private Integer[] movieID = {
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05
            ,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10
    };

    @Override
    public int getCount() {
        return movieID.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, final ViewGroup viewGroup) {
        ImageView imageView =  new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(250,350));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(movieID[position]);

        final int pos = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View)View.inflate(context,R.layout.dialog,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView movie = (ImageView)dialogView.findViewById(R.id.img_movie);
                TextView movie_name = (TextView)dialogView.findViewById(R.id.movie_name);
                ImageButton btn_like = (ImageButton)dialogView.findViewById(R.id.btn_like);
                final TextView tv_like = (TextView)dialogView.findViewById(R.id.tv_like);

                helper= new myDBHelper(context);
                sqLiteDatabase = helper.getReadableDatabase();
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT likeNum FROM voteMovie",null);
                cursor.moveToPosition(pos);
                final Integer likenum= cursor.getInt(0);

                tv_like.setText(Integer.toString(likenum));
                btn_like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sqLiteControl = new SQLiteControl(helper);
                        sqLiteControl.update(movieTitle[pos],likenum);
                        tv_like.setText(Integer.toString(likenum+1));
                    }
                });
                cursor.close();
                sqLiteDatabase.close();
                movie.setImageResource(movieID[pos]);
                movie_name.setText(movieTitle[pos]);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기",null);
                dlg.show();
            }
        });
        return imageView;
    }
}

