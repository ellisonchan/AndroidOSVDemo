package com.ellison.osvdemo.recognition.service.provider

object RecognitionProvider {
    fun provideRecognition(): IRecognitionEngine = CerenceRecognitionEngine()
}