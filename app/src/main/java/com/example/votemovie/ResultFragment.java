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

public class ResultFragment extends Fragment {
    View view;
    myDBHelper helper;
    SQLiteDatabase sqLiteDatabase;

    public ResultFragment(myDBHelper _helper){
        this.helper = _helper;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.result_fragment, container, false);

        helper= new myDBHelper(getActivity());
        sqLiteDatabase = helper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM voteMovie;",null);

        TextView tv[] = new TextView[cursor.getCount()];
        RatingBar rbar[] = new RatingBar[cursor.getCount()];
        Integer tvID[]= {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9,R.id.tv10};
        Integer rbarID[] = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9,R.id.rbar10};

        for (int i = 0; i < cursor.getCount() ; i++) {
            tv[i]=(TextView)view.findViewById(tvID[i]);
            rbar[i]=(RatingBar)view.findViewById(rbarID[i]);
        }

        while (cursor.moveToNext()){
            tv[cursor.getPosition()].setText(cursor.getString(0));
            rbar[cursor.getPosition()].setRating(Float.parseFloat(cursor.getString(1)));
        }
        cursor.close();
        sqLiteDatabase.close();
        return view;
    }
}
