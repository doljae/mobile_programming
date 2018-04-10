package com.example.seokjae.lab2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText edit_url;
    public String url_value;
    public Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    public void init()
    {
        edit_url=findViewById(R.id.editText1);
        btnGo=findViewById(R.id.btnNext);

        btnGo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                url_value=edit_url.getText().toString();
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                Bundle mybundle=new Bundle();
                mybundle.putString("url",url_value);
                intent.putExtras(mybundle);
                if(url_value.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"주소를 다시 입력해주세요" ,Toast.LENGTH_LONG).show();
                }
                startActivityForResult(intent,1234);
            }
        });
    }
}
