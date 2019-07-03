package com.example.animation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button alpha;
    private Button rotate;
    private Button translate;
    private Button scale;
    private Button combine;
    private Animation loadAnimation;
    private ImageView imageView;
    private AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alpha = findViewById(R.id.aplha);
        imageView = findViewById(R.id.imageView);
        rotate = findViewById(R.id.rotate);
        translate = findViewById(R.id.translate);
        scale = findViewById(R.id.scale);
        combine = findViewById(R.id.combine);

        alpha.setOnClickListener(this);
        rotate.setOnClickListener(this);
        translate.setOnClickListener(this);
        scale.setOnClickListener(this);
        combine.setOnClickListener(this);
        animationSet = new AnimationSet(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aplha:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.rotate:
                loadAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.translate:
                loadAnimation = AnimationUtils.loadAnimation(this,R.anim.translate);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.scale:
                loadAnimation = AnimationUtils.loadAnimation(this,R.anim.scale);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.combine:
                animationSet.setDuration(1000);
                Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
                animationSet.addAnimation(alpha);
                Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
                animationSet.addAnimation(rotate);
                Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);
                animationSet.addAnimation(translate);
                Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
                animationSet.addAnimation(scale);
                imageView.startAnimation(animationSet);
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(MainActivity.this, "onAnimationStart", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "onAnimationEnd", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Toast.makeText(MainActivity.this, "onAnimationRepeat", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            default:
                break;
        }
    }
}