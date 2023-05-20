package mobile.android.partthree.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mobile.android.partthree.repositories.DataRepository

class AppViewModelFactory(private val application: Application,
                          private val dataRepository: DataRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass){
            when{
              modelClass.isAssignableFrom(ScreenOneViewModel::class.java) -> {
                  ScreenOneViewModel(application, dataRepository)
              }
                modelClass.isAssignableFrom(ScreenTwoViewModel::class.java) -> {
                    ScreenTwoViewModel(application, dataRepository)
                }
                else -> throw IllegalArgumentException("Unknow Viewmodel class")
            }
        } as T
}