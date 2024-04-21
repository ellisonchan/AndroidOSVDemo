package com.ellison.osvdemo.profiling

import android.app.ActivityManager
import android.app.ApplicationStartInfo
import android.os.Bundle
import android.os.ProfilingManager
import android.os.ProfilingResult
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ellison.osvdemo.common.TAG_PROFILING
import com.ellison.osvdemo.common.printApplicationStartInfo
import com.ellison.osvdemo.common.printProfilingResult
import com.ellison.osvdemo.databinding.ProfilingBinding
import java.util.concurrent.Executors
import java.util.function.Consumer

class ProfilingActivity : AppCompatActivity() {
    private val singleThreadExecutor = Executors.newSingleThreadExecutor()

    private val profilingResultConsumer = Consumer<ProfilingResult> {
        Log.d(TAG_PROFILING, "accept profilingResult:${it.printProfilingResult()}")
    }

    private val profilingManager by lazy {
        getSystemService(ProfilingManager::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(
            TAG_PROFILING, "ProfilingActivity#onCreate()"
        )

        val binding = ProfilingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dump.setOnClickListener {
            Log.d(TAG_PROFILING, "button dump tapped")

            profilingManager.registerForAllProfilingResults(
                singleThreadExecutor,
                profilingResultConsumer
            )
        }

        binding.request.setOnClickListener {
            Log.d(TAG_PROFILING, "button request tapped")

            profilingManager.requestProfiling(
                // ProfilingManager.PROFILING_TYPE_SYSTEM_TRACE,
                // ProfilingManager.PROFILING_TYPE_JAVA_HEAP_DUMP,
                ProfilingManager.PROFILING_TYPE_STACK_SAMPLING,
                // ProfilingManager.PROFILING_TYPE_HEAP_PROFILE,
                null,
                // null,
                "TEST_FOR_PROFILING_MANAGER",
                null,
                singleThreadExecutor,
                profilingResultConsumer
            )
        }

        binding.stop.setOnClickListener {
            Log.d(TAG_PROFILING, "button stop tapped")

            profilingManager.unregisterForAllProfilingResults(profilingResultConsumer)
        }
    }
}