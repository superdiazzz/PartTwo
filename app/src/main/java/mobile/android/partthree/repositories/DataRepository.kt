package mobile.android.partthree.repositories

import android.content.Context

class DataRepository(private val context: Context) {

    companion object {

        private var INSTANCE : DataRepository ?= null

        fun getInstance(context: Context) : DataRepository = INSTANCE ?: synchronized(DataRepository::class.java){
            DataRepository(context).also {
                INSTANCE = it
            }
        }

        fun getDataContact(){

        }

    }
}