package com.example.seokjae.lab2_1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText edit_name;
    public EditText edit_age;
    public Button btn_send;
    public String name_value;
    public String age_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        edit_name = findViewById(R.id.editText1);
        edit_age = findViewById(R.id.editText2);
        btn_send = findViewById(R.id.btnSendData);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_value = edit_name.getText().toString();
                age_value = edit_age.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                Bundle mybundle = new Bundle();
                mybundle.putString("name", name_value);
                mybundle.putString("age", age_value);
                intent.putExtras(mybundle);
                Toast.makeText(getApplicationContext(),"Student info: "+name_value+", "+age_value ,Toast.LENGTH_LONG).show();
                startActivityForResult(intent, 1234);
            }
        });

    }
}


