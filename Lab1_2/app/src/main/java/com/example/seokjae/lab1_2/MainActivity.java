package com.example.seokjae.lab1_2;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText edit_name; //declare EditText variable
    public Button btn_clear; //declare Button variable(clear button)
    public Button btn_print; //declare Button variable(print button)
    public TextView view; //declare TextView variable(printed text)

    @Override //
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Conduct Layout Inflation by using setContentView method

        init();
    }

    public void init() {
        edit_name = (EditText) findViewById(R.id.view1); //find view object(id : view1)
        btn_clear = (Button) findViewById(R.id.button1); //find view object(id : button1(clear))
        btn_print = (Button) findViewById(R.id.button2); //find view object(id : button2(print))
        view = (TextView) findViewById(R.id.view2); //find view object(id : view2)
    }
    //method for clear edit_name text
    public void clearClicked(View v) {
        edit_name.setText("");
        view.setText("");
    }
    //method for read text On EditText and print it
    public void printClicked(View v) {
        String text = edit_name.getText().toString();
        view.setText(text);
    }
}