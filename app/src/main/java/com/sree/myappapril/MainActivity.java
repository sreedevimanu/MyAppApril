package com.sree.myappapril;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity  {
Animation animation,animation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
        imageView.startAnimation(animation);

        TextView textView =(TextView)findViewById(R.id.textView);
        animation1 =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
        textView.startAnimation(animation1);

        //Splash screen using Thread
        Thread obj = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(6000);
                    Intent i = new Intent(getApplicationContext(),SecondPage.class);
                    startActivity(i);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        obj.start();

        //splashscreen using handler
      /*
       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),SecondPage.class);
                startActivity(i);
            }
        },3000);

       */


    }
}