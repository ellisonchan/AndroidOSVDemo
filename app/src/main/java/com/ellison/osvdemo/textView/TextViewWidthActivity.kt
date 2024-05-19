package com.ellison.osvdemo.textView

import android.os.Bundle
import android.text.Highlights
import androidx.appcompat.app.AppCompatActivity
import com.ellison.osvdemo.databinding.TextviewLayoutWidthBinding

class TextViewWidthActivity : AppCompatActivity() {
    companion object {
        const val TEXT = "val builder = Highlights.Builder()"
        const val TEXT_LONG = "val builder = Highlights.Builder()val val val val val val val val "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = TextviewLayoutWidthBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        with(binding.textview1) {
//            text = TEXT
//            val builder = Highlights.Builder()
//                .addRange(yellowPaint, 0, 3)
//                .addRange(greenPaint, 14, 24)
//                .addRange(greenPaint, 25, 32)
//            highlights = builder.build()
//        }

    }
}