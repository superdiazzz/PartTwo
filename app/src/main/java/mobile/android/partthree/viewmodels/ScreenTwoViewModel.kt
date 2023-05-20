package mobile.android.partthree.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import mobile.android.partthree.`interface`.ScreenTwoListener
import mobile.android.partthree.repositories.DataRepository
import mobile.android.partthree.utils.Coroutines

class ScreenTwoViewModel (application: Application,
                          private val dataRepository: DataRepository
)
    : AndroidViewModel(application) {

    var listener : ScreenTwoListener ?= null


    fun getDetail(id: String){

        Coroutines.main {
            val res = dataRepository.getDataContact()
            val list = res.dataResponse
            list.forEach {
                if(it.id == id){
                    listener?.onSuccess(it)
                }
            }
        }

    }

}