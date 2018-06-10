package com.example.seokjae.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    EditText editText;
    static final String TAG="DEBUG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        editText=findViewById(R.id.editText);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String input=editText.getText().toString();
                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "External.txt");
                    try {
                        FileWriter fw = new FileWriter(file, false);
                        fw.write(input);
                        fw.close();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Log.d(TAG, "External Storage is not ready");
                }
                Toast.makeText(getApplicationContext(),"Done writing SD :External.txt",Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(" ");
            }
        });
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                StringBuffer buffer = new StringBuffer();
                String data = null;
                String path = Environment.getExternalStorageDirectory() + "/External.txt";
                try {
                    BufferedReader eReader = new BufferedReader(new FileReader(path));
                    data = eReader.readLine();
                    while(data != null)
                    {
                        buffer.append(data);
                        data = eReader.readLine();
                    }
                    editText.setText(buffer.toString()+"\n");
                    eReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),"Done Reading SD :External.txt",Toast.LENGTH_SHORT).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
