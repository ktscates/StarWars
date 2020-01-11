package com.example.starwars;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = (ImageView)findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        logo.startAnimation(animation);

        TextView text = (TextView)findViewById(R.id.text);
        Animation animations = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        text.startAnimation(animations);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Characters.class));
            }
        });

        MediaPlayer starwars = MediaPlayer.create(MainActivity.this, R.raw.starwars);
        starwars.start();
    }
    
}
