package com.example.android.servicereportscanner;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


public class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    public OnSwipeTouchListener(Context ctx){
        gestureDetector = new GestureDetector(ctx, new GestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }
    private final class GestureListener extends SimpleOnGestureListener {
        public void onSwipeRight(){}
        public void onSwipeLeft() {}

        //Determine how much movement is considered a swipe (aka number of dp)
        private static final int swipe_threshold = 100;
        //Determine how much speed of the movement id consider a swipe
        private static final int swipe_speed = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffX = e2.getX() - e1.getX();
                if(Math.abs(diffX) > swipe_threshold && velocityX > swipe_speed){
                    if(diffX > 0){
                        onSwipeRight();
                    }else {
                        onSwipeLeft();
                    }
                }return true;
            }catch (Exception e) {
                e.printStackTrace();
            }return result;
        }
    }
}
