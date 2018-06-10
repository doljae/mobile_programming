package com.example.seokjae.lab6_3;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    Button button1;
    Button button2;
    EditText editText1;
    EditText editText2;
    String[] items={};
    ListView listView;
    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        listView=findViewById(R.id.listView);



        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String name=editText1.getText().toString();
                String studentNum=editText2.getText().toString();
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(studentNum))
                    Toast.makeText(getApplicationContext(),"모든 항목을 입력해주세요.",Toast.LENGTH_SHORT).show();
                else
                    {
                        insert(name, studentNum);
                        invalidate();
                        editText1.setText("");
                        editText2.setText("");
                    }
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String name=editText1.getText().toString();
                if(TextUtils.isEmpty(name))
                    Toast.makeText(getApplicationContext(),"이름을 입력해주세요.",Toast.LENGTH_SHORT).show();
                else
                {
                    delete(name);
                    invalidate();
                    editText1.setText("");
                    editText2.setText("");
                }

            }
        });
    }
    public void insert(String name, String studentNum) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("studentNum", studentNum);
        db.insert("student", null, values);
    }
    public void delete (String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
        Log.i("db1", name + "정상적으로 삭제 되었습니다.");
    }

    public void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);
        items=new String[c.getCount()];
        int count=0;
        while (c.moveToNext()) {
            items[count]= c.getString(c.getColumnIndex("name"))
                    +" "+c.getString(c.getColumnIndex("studentNum"));
            count++;
        }
        c.close();
    }
    private void invalidate(){
        select();
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
