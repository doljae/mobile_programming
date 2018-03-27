package com.example.seokjae.lab1_1;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int i = 0; //declare variable for counting number of button press
    ImageView imageview = null; //declare variable for image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Conduct Layout Inflation by using setContentView method

        Button button = (Button)findViewById(R.id.button); //find view object(id : button(clear))
        imageview = (ImageView)findViewById(R.id.imageView); //find view object(id : imageView)

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                i = 1 - i;//if you push button, it change variable i, and change image

                if ( i == 0 ){
                    imageview.setImageResource(R.drawable.android_red);
                }
                else{
                    imageview.setImageResource(R.drawable.android_blue);
                }

            }
        });
    }
}