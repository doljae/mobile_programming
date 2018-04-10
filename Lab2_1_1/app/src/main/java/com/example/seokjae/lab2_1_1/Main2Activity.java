package com.example.seokjae.lab2_1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn_return=findViewById(R.id.btnReturn);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                Bundle mybundle=intent.getExtras();
                String name=mybundle.getString("name");
                String age=mybundle.getString("age");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
