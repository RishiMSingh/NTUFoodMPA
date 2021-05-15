package com.example.foodcollectionntu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodcollectionntu.User.UserPage;

public class SplashScreen extends AppCompatActivity {

    private static final long SPLASH_TIMER = 5000;
    //Splashscreen variables
    ImageView backgroundImage;
    TextView splashLine;

    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Hooks
        backgroundImage = findViewById(R.id.backgroundSplash_image);
        splashLine = findViewById(R.id.splash_line);

        //Animation
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set Animations
        backgroundImage.setAnimation(sideAnim);
        splashLine.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(SplashScreen.this, UserPage.class);
                startActivity(intent);

                
            }
        },SPLASH_TIMER);
    }
}