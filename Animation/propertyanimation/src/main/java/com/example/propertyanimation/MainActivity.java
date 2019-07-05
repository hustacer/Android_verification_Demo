package com.example.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button alpha;
    private Button rotate;
    private Button translate;
    private Button scale;
    private Button combine;
    private Button combine1;
    private ImageView imageView;
    ObjectAnimator mObjectAnimator;

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
        combine1 = findViewById(R.id.combine1);

        alpha.setOnClickListener(this);
        rotate.setOnClickListener(this);
        translate.setOnClickListener(this);
        scale.setOnClickListener(this);
        combine.setOnClickListener(this);
        combine1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float curTranslationY = imageView.getTranslationY();
        switch (v.getId()) {
            case R.id.aplha:
                mObjectAnimator = ObjectAnimator.ofFloat(imageView, "alpha",
                        1f, 0f, 1f, 0f, 1f, 0f, 1f);
                mObjectAnimator.setDuration(2000);
                mObjectAnimator.start();
                break;
            case R.id.rotate:
                mObjectAnimator = ObjectAnimator.ofFloat(imageView, "translationY",
                        curTranslationY, curTranslationY+100f);
                mObjectAnimator.setDuration(2000);
                mObjectAnimator.start();
                break;
            case R.id.translate:
                imageView.animate().translationY(curTranslationY + 500)
                        .scaleX(5).scaleY(5).setDuration(1000);
                break;
            case R.id.scale:
                imageView.animate().translationYBy(curTranslationY + 500)
                        .scaleX(5).scaleY(5).setDuration(1000);
                break;
            case R.id.combine:
                ObjectAnimator translationY
                        = ObjectAnimator.ofFloat(imageView, "translationY",
                        curTranslationY, curTranslationY + 500f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY",
                        1f, 5f, 1f);
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX",
                        1f, 5f, 1f);
                AnimatorSet aniSet = new AnimatorSet();
                aniSet.playTogether(translationY,scaleX,scaleY);
                aniSet.setDuration(2000);
                aniSet.start();
                break;
            case R.id.combine1:
                imageView.animate()
                        .setDuration(5000)
                        .alpha(0)
                        .alphaBy(0)
                        .rotation(360)
                        .rotationBy(360)
                        .rotationX(360)
                        .rotationXBy(360)
                        .rotationY(360)
                        .rotationYBy(360)
                        .scaleX(1)
                        .scaleXBy(1)
                        .scaleY(1)
                        .scaleYBy(1)
                        .translationX(100)
                        .translationXBy(100)
                        .translationY(100)
                        .translationYBy(100)
                        .translationZ(100)
                        .translationZBy(100)
                        .x(10)
                        .xBy(10)
                        .y(10)
                        .yBy(10)
                        .z(10)
                        .zBy(10)
                        .setInterpolator(new BounceInterpolator())//回弹
                        .setInterpolator(new AccelerateDecelerateInterpolator())//加速再减速
                        .setInterpolator(new AccelerateInterpolator())//加速
                        .setInterpolator(new DecelerateInterpolator())//减速
                        .setInterpolator(new LinearInterpolator())//线性
                        .setStartDelay(1000);
                break;
            default:
                break;
        }
    }
}
