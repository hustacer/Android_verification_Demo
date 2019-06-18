package com.example.com.gesturedetector_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private TextView textView;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        mGestureDetector = new GestureDetector(new gestureListener());

        textView.setOnTouchListener(this);
        textView.setFocusable(true);
        textView.setClickable(true);
        textView.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private class gestureListener implements GestureDetector.OnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onDown", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onShowPress", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Toast.makeText(MainActivity.this, "onScroll", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onLongPress", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(MainActivity.this, "onFling", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
