package com.example.seokjae.lab5_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    EditText editText1;
    Button button1;
    TextView tvCounter1, tvCounter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.button);
        tvCounter1 = (TextView) findViewById(R.id.textView);
        tvCounter2 = (TextView) findViewById(R.id.textView2);


        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId()) {
                    case com.example.seokjae.lab5_2.R.id.button:
                        tvCounter1.setText("");
                        tvCounter2.setText("= ?");
                        new FactorialTask().execute(Long.parseLong(editText1.getText().toString()));
                        break;
                    default:
                        break;
                }
            }
        });
    }
    class FactorialTask extends AsyncTask<Long, Long, Long> {
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
        @Override
        protected void onPostExecute(Long result) {
            super.onPostExecute(result);
            tvCounter2.setText(" = " + result);
        }
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            tvCounter1.append(" "+Integer.toString(values[0].intValue()));
        }
        @Override
        protected Long doInBackground(Long... params) {
            long result = 1;
            long num = params[0];
            for(long j=num; j>=1; j--){
                try{Thread.sleep(500);
                    publishProgress(j);
                }catch (Exception e){}
            }
            for (long i = 1; i <= num; i++) {
                result = result * i;
            }
            return result;
        }
    }
}

