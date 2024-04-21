package com.ellison.osvdemo.recognition.service

import android.content.Intent
import android.speech.RecognitionService
import com.ellison.osvdemo.recognition.service.provider.IRecognitionEngine
import com.ellison.osvdemo.recognition.service.provider.RecognitionProvider

class CommonRecognitionService : RecognitionService() {
    private val recognitionEngine: IRecognitionEngine by lazy {
        RecognitionProvider.provideRecognition()
    }

    override fun onCreate() {
        super.onCreate()

        recognitionEngine.init()
    }

    override fun onStartListening(intent: Intent?, callback: Callback?) {
        // Todo parse parameter from intent
        val params: String = ""

        recognitionEngine.startASR(params, callback)
    }

    override fun onStopListening(callback: Callback?) {
        recognitionEngine.stopASR(callback)
    }

    override fun onCancel(callback: Callback?) {
        recognitionEngine.release(callback)
    }
}