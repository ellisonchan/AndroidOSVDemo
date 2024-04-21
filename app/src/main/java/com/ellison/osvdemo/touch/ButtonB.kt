package com.ellison.osvdemo.touch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

class ButtonB internal constructor(context: Context?, attributeSet: AttributeSet) : androidx.appcompat.widget.AppCompatButton(
    context!!,
    attributeSet
) {
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        // Log.d("Touch", "ButtonB#dispatchTouchEvent() event:$event")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("Touch", "ButtonB#onTouchEvent() event:$event")

        return super.onTouchEvent(event)
    }
}