package com.example.seokjae.lab5_1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int i = 0;
    Thread myThread1;
    Thread myThread2;
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            updateThread();
        }
    };
    Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            updateThread2();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myThread1.start();
                myThread2.start();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        myThread1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        handler1.sendMessage(handler1.obtainMessage());
                        Thread.sleep(getRandomTime(500, 3000));
                    } catch (Throwable t) {
                    }
                }
            }
        });
        myThread2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        handler2.sendMessage(handler2.obtainMessage());
                        Thread.sleep(getRandomTime(500,3000));
                    } catch (Throwable t) {
                    }
                }
            }
        });
    }

    public int getRandomTime(int min, int max)
    {
        return min+(int)(Math.random()*(max-min));
    }
    private void updateThread() {
        int mod = i % 3;
        switch (mod) {
            case 0:
                i++;
                imageView1.setImageResource(R.drawable.dog_wink);
                editText.append("dog #0 state :0,\n");
                break;
            case 1:
                i++;
                imageView1.setImageResource(R.drawable.dog_eat);
                editText.append("dog #0 state :1,\n");
                break;
            case 2:
                i++;
                imageView1.setImageResource(R.drawable.dog_write);
                editText.append("dog #0 state :2,\n");
                break;
        }
    }
    private void updateThread2() {
        int mod = i % 3;
        switch (mod) {
            case 0:
                i++;
                imageView2.setImageResource(R.drawable.dog_wink);
                editText.append("dog #1 state :0,\n");
                break;
            case 1:
                i++;
                imageView2.setImageResource(R.drawable.dog_eat);
                editText.append("dog #1 state :1,\n");
                break;
            case 2:
                i++;
                imageView2.setImageResource(R.drawable.dog_write);
                editText.append("dog #1 state :2,\n");
                break;
        }
    }
}
