package com.ellison.osvdemo.common

import android.app.ApplicationStartInfo

fun ApplicationStartInfo.printApplicationStartInfo() =
    "ApplicationStartInfo{intent:$intent launchMode:$launchMode" +
            " packageUid:$packageUid realUid:$realUid" +
            " pid:$pid processName:$processName reason:$reason " +
            " startType:$startType startupState:$startupState startupTimestamps:$startupTimestamps" +
            " wasForceStopped:${wasForceStopped()}}"