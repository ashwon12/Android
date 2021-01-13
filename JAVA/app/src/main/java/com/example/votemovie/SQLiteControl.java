package com.example.votemovie;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteControl {

    myDBHelper helper;
    SQLiteDatabase sqLiteDatabase;

    // 생성자
    public SQLiteControl(myDBHelper _helper){
        this.helper = _helper;
    }

    // DB insert
    public void insert(String movieName,Integer likeNum){
        sqLiteDatabase = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("movieName",movieName);
        values.put("likeNum",likeNum);

        sqLiteDatabase.insert("voteMovie",null,values);
    }

    //DB select
    public String[] select(){
        sqLiteDatabase = helper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("voteMovie",null,null,null,null,null,null);
        String[] column = new String[]{"movieName", "likeNum"};
        String[] data = new String[column.length];

        while (cursor.moveToNext()){
            for (int i = 0; i <column.length ; i++) {
                data[i] = cursor.getString(cursor.getColumnIndex(column[i]));
            }
        }
        cursor.close();
        return data;
    }

    public void update(String name,Integer num){
        sqLiteDatabase = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("likeNum",num+1);

        sqLiteDatabase.update("voteMovie",values,"movieName=?",new String[]{name});
    }

}
