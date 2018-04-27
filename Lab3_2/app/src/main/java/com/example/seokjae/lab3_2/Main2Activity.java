package com.example.seokjae.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button button2;
    TextView textview1;
    TextView textview2;
    TextView textview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textview1=(TextView)findViewById(R.id.textview1);
        textview2=(TextView)findViewById(R.id.textview2);
        textview3=(TextView)findViewById(R.id.textview3);
        button2=(Button)findViewById(R.id.button2);

        String string1=getIntent().getStringExtra("info1");
        String string2=getIntent().getStringExtra("info2");
        String string3=getIntent().getStringExtra("info3");
        textview1.setText(string1);
        textview2.setText(string2);
        textview3.setText(string3);
        
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}

