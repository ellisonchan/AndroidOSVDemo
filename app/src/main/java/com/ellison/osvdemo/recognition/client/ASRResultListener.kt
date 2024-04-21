package com.ellison.osvdemo.recognition.client

interface ASRResultListener {
    fun onPartialResult(result: String)

    fun onFinalResult(result: String)
}