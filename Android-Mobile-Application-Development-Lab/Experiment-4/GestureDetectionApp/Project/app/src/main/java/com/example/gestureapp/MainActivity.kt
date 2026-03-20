package com.example.gestureapp

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {

    private lateinit var tvGesture: TextView
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvGesture = findViewById(R.id.tvGesture)
        gestureDetector = GestureDetector(this, this)
        gestureDetector.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent?) = true
    override fun onShowPress(e: MotionEvent?) {}
    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        tvGesture.text = "Single Tap"
        return true
    }
    override fun onScroll(
        e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float
    ) = true
    override fun onLongPress(e: MotionEvent?) {
        tvGesture.text = "Long Press"
    }
    override fun onFling(
        e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float
    ): Boolean {
        if (e1 != null && e2 != null) {
            val diffX = e2.x - e1.x
            val diffY = e2.y - e1.y
            if (Math.abs(diffX) > Math.abs(diffY)) {
                tvGesture.text = if (diffX > 0) "Swipe Right" else "Swipe Left"
            } else {
                tvGesture.text = if (diffY > 0) "Swipe Down" else "Swipe Up"
            }
        }
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        tvGesture.text = "Double Tap"
        return true
    }
    override fun onDoubleTapEvent(e: MotionEvent?) = true
    override fun onSingleTapConfirmed(e: MotionEvent?) = true
}
