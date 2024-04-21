package com.ellison.osvdemo

import android.app.ActivityManager
import android.app.Application
import android.app.ApplicationStartInfo
import android.os.ProfilingManager
import android.util.Log
import com.ellison.osvdemo.common.TAG_APP_START
import com.ellison.osvdemo.common.printApplicationStartInfo
import java.util.concurrent.Executors
import java.util.function.Consumer

class OSVApplication : Application() {
    val executor = Executors.newSingleThreadExecutor()

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG_APP_START, "OSVApplication#onCreate()")

        val profilingManager: ProfilingManager? = null

        val activityManager = getSystemService(ActivityManager::class.java)
        val applicationStartInfoList = activityManager.getHistoricalProcessStartReasons(3)
        val applicationStartConsumer = Consumer<ApplicationStartInfo> {
            Log.d(TAG_APP_START, "changed applicationStartInfo:${it.printApplicationStartInfo()}")
        }

        Log.d(TAG_APP_START, "Original applicationStartInfo list:\n")
        for (info in applicationStartInfoList) {
            Log.d(TAG_APP_START, "${info.printApplicationStartInfo()}")
        }

        activityManager.addApplicationStartInfoCompletionListener(
            executor,
            applicationStartConsumer
        )

//        activityManager.getHistoricalProcessExitReasons()

//        activityManager.removeApplicationStartInfoCompletionListener(
//            applicationStartConsumer
//
    }
}