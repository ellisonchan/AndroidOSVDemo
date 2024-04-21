# OSV Demo for new Android version

## Scope for Android 15

### 1. ApplicationStartInfo

<https://github.com/ellisonchan/AndroidOSVDemo/tree/main/app/src/main/java/com/ellison/osvdemo/appStart/AppStartActivity.kt>

Output following info contents according to `ApplicationStartInfo` API.

```bash
 03-30 20:46:27.461  4499  4499 D AppStart: OSVApplication#onCreate()
 03-30 20:46:27.477  4499  4499 D AppStart: Original applicationStartInfo list:
 03-30 20:46:27.484  4499  4499 D AppStart: ApplicationStartInfo{intent:Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10000000 cmp=com.ellison.demo/.appStart.AppStartActivity } launchMode:0 packageUid:10197 realUid:10197 pid:0 processName:com.ellison.demo reason:6  startType:1 startupState:0 startupTimestamps:{0=56169205650, 3=56491075233} wasForceStopped:false}
 ​
 03-30 20:46:27.638  4499  4499 D AppStart: AppStartActivity#onCreate()
 03-30 20:46:27.961  4499  4563 D AppStart: ApplicationStartInfo{intent:Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10000000 cmp=com.ellison.demo/.appStart.AppStartActivity } launchMode:0 packageUid:10197 realUid:10197 pid:0 processName:com.ellison.demo reason:6  startType:1 startupState:2 startupTimestamps:{0=56169205650, 3=56491075233} wasForceStopped:false}
```

### 2. ProfilingManager

<https://github.com/ellisonchan/AndroidOSVDemo/tree/main/app/src/main/java/com/ellison/osvdemo/profiling/ProfilingActivity.kt>

Request dumping java heap from codes by `ProfilingManager`.

```kotlin
class ProfilingActivity : AppCompatActivity() {
    private val singleThreadExecutor = Executors.newSingleThreadExecutor()

    private val profilingResultConsumer = Consumer<ProfilingResult> {
        Log.d(TAG_PROFILING, "accept profilingResult:${it.printProfilingResult()}")
    }

    private val profilingManager by lazy {
        getSystemService(ProfilingManager::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        ...
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
        ...
    }
}
```

And output ProfilingResult as below:

```bash
04-21 19:37:32.220  7184  7270 D Profiling: accept profilingResult:ProfilingResult{errorCode:0 errorMessage:null resultFilePath:/data/user/0/com.ellison.osvdemo/files/profiling/profile_testforprofilingmana_2024-04-21-19-37-26.perfetto-java-heap-dump tag:TEST_FOR_PROFILING_MANAGER}
```

## Scope for Android 14

> **Warning**
>
> Due to grammatical gender feature, need ***Android Studio Giraffe Canary 7*** or higher.
>
> You could download that [here](https://androidstudio.googleblog.com/2023/02/android-studio-giraffe-canary-7-now.html).

### :camera_flash: [1. Capture Callback](https://github.com/ellisonchan/AndroidUDemo/blob/main/app/src/main/java/com/ellison/demo/capture/)



<div align=center><img src="https://p9-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/b5b1f91ec43244c392f0518ed99635c1~tplv-k3u1fbpfcp-zoom-in-crop-mark:1512:0:0:0.awebp?" width="30%"></div>

### :memo: [2. TextView Highlights & Search Highlight](https://github.com/ellisonchan/AndroidUDemo/blob/main/app/src/main/java/com/ellison/demo/textView/)

#### 2.1 hightlights

<div align=center><img src="https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/d1dfcd45a4ff4f90ab1d453e854fd51d~tplv-k3u1fbpfcp-zoom-in-crop-mark:1512:0:0:0.awebp?" width="50%"></div>

<div align=center><img src="https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/5a7f4dc64f324c34bfb702197225c1e2~tplv-k3u1fbpfcp-zoom-in-crop-mark:1512:0:0:0.awebp?" width="50%"></div>


#### 2.2 Search Hightlight

<div align=center><img src="https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/a60cdb92188946dfaf3195bf24bf6d2e~tplv-k3u1fbpfcp-zoom-in-crop-mark:1512:0:0:0.awebp?" width="50%"></div>

### 👩 3. [Grammatical Gender API](https://github.com/ellisonchan/AndroidUDemo/blob/main/app/src/main/java/com/ellison/demo/personalization/)

#### 3.1 Update Grammatical Gender preference by API

<div align=center><img src="/screenshot/update-gender-recreate.gif" width="50%"></div>

#### 3.2 Config changes and update gender's text manually

<div align=center><img src="https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/627505a121b34e829b86fa0a30392496~tplv-k3u1fbpfcp-watermark.image?" width="50%"></div>

### 📤 4. [Custom Action on ShareSheet](https://github.com/ellisonchan/AndroidUDemo/blob/main/app/src/main/java/com/ellison/demo/share/)

<div align=center><img src="/screenshot/share_custom.png" width="50%"></div>


### :copyright: License                                                                                                                                                                                                                    

```
MIT License

Copyright (c) 2023 Ellison Chan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
