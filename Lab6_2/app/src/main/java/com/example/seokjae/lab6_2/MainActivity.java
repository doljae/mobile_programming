package com.example.seokjae.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button save, recall, clear;
    String username, password;
    EditText userinput, passinput;
    SharedPreferences sh_Pref1;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recall = findViewById(R.id.button1);
        save = findViewById(R.id.button2);
        clear=findViewById(R.id.button3);
        passinput = findViewById(R.id.editText1);
        userinput = findViewById(R.id.editText2);
        save.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = userinput.getText().toString();
                password = passinput.getText().toString();
                sharedPreferences1();
                Toast.makeText(getApplicationContext(), "Details are saved", Toast.LENGTH_SHORT).show();
            }
        });
        clear.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                userinput.setText("");
                passinput.setText("");
            }
        });
        recall.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                applySharedPreference1();

            }
        });

    }
    public void sharedPreferences1()
    {
        sh_Pref1=getSharedPreferences("Login Credentials",MODE_PRIVATE);
        toEdit=sh_Pref1.edit();
        toEdit.putString("Username",username);
        toEdit.putString("Password",password);
        toEdit.commit();
    }
    public void applySharedPreference1()
    {
        sh_Pref1=getSharedPreferences("Login Credentials",MODE_PRIVATE);
        if(sh_Pref1!=null&&sh_Pref1.contains("Username"))
        {
            String name=sh_Pref1.getString("Username","noname");
            String password=sh_Pref1.getString("Password","nopassword");
            userinput.setText(name);
            passinput.setText(password);
        }
    }

}