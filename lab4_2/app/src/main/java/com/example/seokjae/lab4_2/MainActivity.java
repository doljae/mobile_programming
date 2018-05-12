package com.example.seokjae.lab4_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean flag = false;
    Animation translate_left;
    Animation translate_right;
    LinearLayout slidingLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        slidingLayout = (LinearLayout) findViewById(R.id.slidingLayout);
        button = (Button) findViewById(R.id.button);
        translate_left = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translate_right = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        slidingAnimationListener animationListener = new slidingAnimationListener();
        translate_left.setAnimationListener(animationListener);
        translate_right.setAnimationListener(animationListener);
    }
    public void onButton1Clicked(View v) {
        if (flag) {
            slidingLayout.startAnimation(translate_right);
        }
        else {
            slidingLayout.setVisibility(View.VISIBLE);
            slidingLayout.startAnimation(translate_left);
        }
    }
    private class slidingAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
            if (flag) {
                slidingLayout.setVisibility(View.INVISIBLE);
                button.setText("OPEN PAGE");
                flag = false;
            }
            else {
                button.setText("CLOSE PAGE");
                flag = true;
            }
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
        }
        @Override
        public void onAnimationStart(Animation animation) {
        }
    }
}