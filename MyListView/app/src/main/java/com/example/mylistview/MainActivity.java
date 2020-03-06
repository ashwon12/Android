package com.example.mylistview;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;
    EditText editText;
    EditText editText2;

    //vnf
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        ListView listView =(ListView)findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new SigerItem("디오","010-1234-5678"));
        adapter.addItem(new SigerItem("백현","010-1234-5678"));

        //눌렀을 때 선택 될 수 있게
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SigerItem item = (SigerItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택:"+item.getName(),Toast.LENGTH_LONG).show();
            }
        });

        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String number = editText2.getText().toString();

                adapter.addItem(new SigerItem(name,number));
                adapter.notifyDataSetChanged();
            }
        });
    }

    //어댑터 클래스 : 데이터 관리
    class SingerAdapter extends BaseAdapter{

        //데이터 관리 할 리스트
        ArrayList<SigerItem> items = new ArrayList<SigerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SigerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SigerItemVIew view = null;
            if(convertView ==null){
                view = new SigerItemVIew((getApplicationContext()));
            } else{
                view =(SigerItemVIew) convertView;
            }

            SigerItem item=items.get(position);
            view.setName(item.getName());
            view.setNumber(item.getNumber());

            return view;
        }
    }
}
