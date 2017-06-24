package com.itcrew.signage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    private ImageView imageView;
    private Integer value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        int waitTime = 2000;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent mainIntent = new Intent().setClass(Splash.this, com.itcrew.signage.LoginActivity.class);
                startActivity(mainIntent);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, waitTime);


    }

}
