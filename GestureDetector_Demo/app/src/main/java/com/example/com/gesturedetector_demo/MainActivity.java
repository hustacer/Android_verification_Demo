package com.example.com.gesturedetector_demo;

import android.support.constraint.solver.Cache;
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
//        mGestureDetector = new GestureDetector(new gestureListener());
//        mGestureDetector.setOnDoubleTapListener(new doubleTapListener());

        // use SimpleOnGestureListener
        mGestureDetector = new GestureDetector(new simpleGestureListener());

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

    private class doubleTapListener implements GestureDetector.OnDoubleTapListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onSingleTapConfirmed", Toast.LENGTH_LONG).show();
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onDoubleTap", Toast.LENGTH_LONG).show();
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onDoubleTap", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 200;

        @Override
        public boolean onDown(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onDown", Toast.LENGTH_LONG).show();
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Toast.makeText(MainActivity.this, "onDoubleTap", Toast.LENGTH_LONG).show();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE &&
                    Math.abs(velocityX) > FLING_MIN_VELOCITY ) {
                Toast.makeText(MainActivity.this, "onFling To Left", Toast.LENGTH_LONG).show();
            } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE &&
                    Math.abs(velocityX) > FLING_MIN_VELOCITY ) {
                Toast.makeText(MainActivity.this, "onFling To Right", Toast.LENGTH_LONG).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
