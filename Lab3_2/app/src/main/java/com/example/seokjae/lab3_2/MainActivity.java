package com.example.seokjae.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button button1;
    RadioGroup radiogroup;
    RadioButton radio1;
    RadioButton radio2;
    EditText edittext1;
    CheckBox check1;
    CheckBox check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiogroup=findViewById(R.id.radiogroup1);
        button1=findViewById(R.id.button1);
        radio1=findViewById(R.id.radio1);
        radio2=findViewById(R.id.radio2);
        edittext1=findViewById(R.id.edittext1);
        check1=findViewById(R.id.check1);
        check2=findViewById(R.id.check2);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String string1=edittext1.getText().toString();
                String string2=getRadio();
                String string3=getCheck();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("info1",string1);
                intent.putExtra("info2",string2);
                intent.putExtra("info3",string3);
                startActivityForResult(intent,1);
            }
        });
    }
    public String getRadio()
    {
        if(radiogroup.getCheckedRadioButtonId()==radio1.getId())
            return "남";
        else
            return "여";
    }
    public String getCheck()
    {
        String string="";
        if(check1.isChecked())
        {
            string=string+"SMS";
        }
        if(check2.isChecked())
        {
            if(string.charAt(0)=='S')
                string=string+'&';
            string=string+"e-mail";
        }
        return string;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        edittext1.setText("");
        radiogroup.clearCheck();
        check1.setChecked(false);
        check2.setChecked(false);
    }
}
