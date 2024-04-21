package com.ellison.osvdemo.appStart

 import android.app.ActivityManager
 import android.app.ApplicationStartInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ellison.osvdemo.common.printApplicationStartInfo
import com.ellison.osvdemo.databinding.ScreenTouchBinding
import java.util.concurrent.Executors
import java.util.function.Consumer

class AppStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(
            "AppStart", "AppStartActivity#onCreate()"
        )

        val activityManager = getSystemService(ActivityManager::class.java)
        val applicationStartInfoList = activityManager.getHistoricalProcessStartReasons(3)

        val binding = ScreenTouchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA.setOnClickListener {
            Log.d("AppStart", "button A tapped")
        }

        binding.btnA.setOnLongClickListener() {
            Log.d("AppStart", "button A tapped")

            return@setOnLongClickListener true
        }

        binding.btnB.setOnClickListener {
            Log.d("AppStart", "button B tapped")
        }

        val applicationStartConsumer = Consumer<ApplicationStartInfo> {
            Log.d("AppStart", "changed applicationStartInfo:${it.printApplicationStartInfo()}")
        }

        activityManager.addApplicationStartInfoCompletionListener(
            Executors.newSingleThreadExecutor(),
            applicationStartConsumer
        )
    }
}