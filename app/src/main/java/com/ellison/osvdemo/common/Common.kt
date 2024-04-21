package com.ellison.osvdemo.common

import android.app.ApplicationStartInfo
import android.os.ProfilingResult

fun ApplicationStartInfo.printApplicationStartInfo() =
    "ApplicationStartInfo{intent:$intent launchMode:$launchMode" +
            " packageUid:$packageUid realUid:$realUid" +
            " pid:$pid processName:$processName reason:$reason " +
            " startType:$startType startupState:$startupState startupTimestamps:$startupTimestamps" +
            " wasForceStopped:${wasForceStopped()}}"

fun ProfilingResult.printProfilingResult() =
    "ProfilingResult{errorCode:$errorCode errorMessage:$errorMessage" +
            " resultFilePath:$resultFilePath tag:$tag}"

const val TAG_APP_START = "AppStart"

const val TAG_PROFILING = "Profiling"