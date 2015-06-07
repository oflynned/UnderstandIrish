package com.glassbyte.irishgrammar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.graphics.PixelFormat;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.glassbyte.irishgrammar.R;


public class SplashScreen extends Activity
{
    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashlayout);
        StartAnimations();


        Thread splash = new Thread() {
            public void run() {
                try {
                    int timer = 0;
                    while (timer < 2000) {
                        sleep(100);
                        timer = timer + 100;
                    }
                    startActivity(new Intent("com.glassbyte.irishgrammar.ClearScreen"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        splash.start();
    }


    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ScrollView l=(ScrollView) findViewById(R.id.scrollView);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.image_view);
        iv.clearAnimation();
        iv.startAnimation(anim);


    }


}
