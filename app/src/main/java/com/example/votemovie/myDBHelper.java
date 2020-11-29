package com.example.votemovie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class myDBHelper extends android.database.sqlite.SQLiteOpenHelper {


    public myDBHelper(Context context) {
        /*생성자*/
        super(context, "voteMovie", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /* 테이블 생성 메소드*/
        sqLiteDatabase.execSQL("CREATE TABLE voteMovie(movieName CHAR(20) PRIMARY KEY, likeNum INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        /*업그레이드 메소드 구현*/
        Log.i("데이터베이스앱 실습", "MyDBHelper : onUpgrade");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS voteMovie");
        onCreate(sqLiteDatabase);
    }
}
