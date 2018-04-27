package com.example.seokjae.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button btn1;
    public Button btn2;
    public fragment1 fstFragment;
    public fragment2 secFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼을 참조
        btn1 = findViewById(R.id.tab1);
        btn2 = findViewById(R.id.tab2);
        //Fragment 객체를 만듬
        fstFragment = new fragment1();
        secFragment = new fragment2();

        //첫번째 Fragment 버튼
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //contain1에 fstFragment를 넣어준다
                getSupportFragmentManager().beginTransaction().replace(R.id.contain1,fstFragment).commit();
            }
        });
        //두번째 Fragment 버튼
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //contain1에 secFragment를 넣어준다
                getSupportFragmentManager().beginTransaction().replace(R.id.contain1,secFragment).commit();
            }
        });
    }
}
