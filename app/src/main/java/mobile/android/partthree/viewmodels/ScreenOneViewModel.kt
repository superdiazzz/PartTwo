package mobile.android.partthree.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import mobile.android.partthree.`interface`.ScreenOneListener
import mobile.android.partthree.repositories.DataRepository
import mobile.android.partthree.utils.Coroutines

class ScreenOneViewModel(application: Application,
                         private val dataRepository: DataRepository)
    : AndroidViewModel(application) {

        var listener : ScreenOneListener ?= null


        fun getListContact(){

            Coroutines.ioWithHandler(work = {
                val res = dataRepository.getDataContact()
                listener?.onSuccess(res.dataResponse)

            }, exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->

            })

        }


}