package com.example.seokjae.lab2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView url_result=findViewById(R.id.textView);
        Button btnGo=findViewById(R.id.btnGo);
        Button btnBack=findViewById(R.id.btnBack);

        Intent intent=getIntent();
        Bundle mybundle=intent.getExtras();
        String url=mybundle.getString("url");
        url_result.setText(url);

        btnGo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent2=getIntent();
                Bundle mybundle=intent2.getExtras();
                String URL=mybundle.getString("url");
                if(URL.startsWith("http://"))
                {

                }
                else
                {
                    URL="http://"+URL;
                }

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(URL));
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"뒤로가기버튼을 눌렀습니다" ,Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
