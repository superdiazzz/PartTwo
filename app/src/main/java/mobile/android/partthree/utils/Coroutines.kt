package mobile.android.partthree.utils

import kotlinx.coroutines.*

object Coroutines {

    // pass function as parameter back to Main thread
    fun main(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.Main).launch {
        work()
    }

    // pass function as paramter and Spread to new Coroutine
    fun io(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.IO).launch {
        work()
    }

    fun ioWithHandler(work: suspend (() -> Unit),
                      exceptionHandler: CoroutineExceptionHandler
    )
            = CoroutineScope(Dispatchers.IO).launch(exceptionHandler){ work() }

    fun mainWithHandler(work: suspend (() -> Unit),
                        exceptionHandler: CoroutineExceptionHandler
    )
            = CoroutineScope(Dispatchers.Main).launch(exceptionHandler) { work() }

    fun delayMain(timeMillis: Long, work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.Main).launch {
        delay(timeMillis)
        work()
    }

    fun delayMainWithHandler(timeMillis: Long, work: suspend (() -> Unit), exceptionHandler: CoroutineExceptionHandler) = CoroutineScope(
        Dispatchers.Main).launch (exceptionHandler){
        delay(timeMillis)
        work()
    }

    fun delayIoWithHandler(timeMillis: Long, work: suspend (() -> Unit), exceptionHandler: CoroutineExceptionHandler) = CoroutineScope(
        Dispatchers.IO).launch(exceptionHandler) {
        delay(timeMillis)
        work()
    }
}