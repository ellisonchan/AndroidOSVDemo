package com.ellison.osvdemo.touch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ellison.osvdemo.databinding.ScreenTouchBinding

class TouchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Touch", "onCreate()")

        val binding = ScreenTouchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA.setOnClickListener {
            Log.d("Touch", "button A tapped")
        }

        binding.btnA.setOnLongClickListener() {
            Log.d("Touch", "button A tapped")

            return@setOnLongClickListener true
        }

        binding.btnB.setOnClickListener {
            Log.d("Touch", "button B tapped")
        }
    }
}