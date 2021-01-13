package com.example.votemovie;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResetFragment extends Fragment {
    View view;
    myDBHelper helper;
    SQLiteDatabase sqLiteDatabase;
    SQLiteControl sqLiteControl;

    public String[] movieTitle = new String[]{"써니","완득이", "괴물", "라디오스타", "비열한 거리", "왕의 남자", "아일랜드", "웰컴투 동막골", "헬보이", "백 투더 퓨쳐"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.reset_fragment, container, false);

        /* 초기화 */
        helper= new myDBHelper(getActivity());
        sqLiteDatabase = helper.getWritableDatabase();
        helper.onUpgrade(sqLiteDatabase,1,2);

        /* 다시 값 넣기 */
        sqLiteControl = new SQLiteControl(helper);
        for (int i = 0; i <movieTitle.length ; i++) {
            Log.i("디비", "dbInsert:"+movieTitle[i]);
            sqLiteControl.insert(movieTitle[i],0);
        }

        /* 읽어오기*/
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM voteMovie;",null);
        TextView tv[] = new TextView[cursor.getCount()];
        TextView rbar[] = new TextView[cursor.getCount()];
        Integer tvID[]= {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9,R.id.tv10};
        Integer rbarID[] = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9,R.id.rbar10};

        for (int i = 0; i < cursor.getCount() ; i++) {
            tv[i]=(TextView)view.findViewById(tvID[i]);
            rbar[i]=(TextView)view.findViewById(rbarID[i]);
        }

        while (cursor.moveToNext()){
            tv[cursor.getPosition()].setText(cursor.getString(0));
            rbar[cursor.getPosition()].setText(cursor.getString(1));
        }

        cursor.close();
        sqLiteDatabase.close();

        return view;
    }
}
