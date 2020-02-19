package com.cesar.movies.utils

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class RecyclerTouchListener {

    class RecyclerTouchListener(context: Context, clickListener: ClickListener) : RecyclerView.OnItemTouchListener {

        private var mGestureDetector: GestureDetector =
            GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(event: MotionEvent): Boolean {
                    return true
                }

            })

        private val mClickListener: ClickListener = clickListener

        override fun onInterceptTouchEvent(recyclerView: RecyclerView, event: MotionEvent): Boolean {

            val child = recyclerView.findChildViewUnder(event.x, event.y)
            if (child != null && mGestureDetector.onTouchEvent(event)) {
                mClickListener.onClick(recyclerView.getChildLayoutPosition(child))
            }
            return false
        }

        override fun onTouchEvent(recyclerView: RecyclerView, event: MotionEvent) {}

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

        }
    }
}