package mobile.android.partthree.repositories

import android.content.Context
import com.google.gson.Gson
import mobile.android.partthree.R
import mobile.android.partthree.model.DataResponse
import mobile.android.partthree.utils.Common

class DataRepository(private val context: Context) {

    companion object {

        private var INSTANCE : DataRepository ?= null

        fun getInstance(context: Context) : DataRepository = INSTANCE ?: synchronized(DataRepository::class.java){
            DataRepository(context).also {
                INSTANCE = it
            }
        }
    }

    fun getDataContact(): DataResponse {

//            val test = Common.inputStreamToString(resources.openRawResource(R.raw.data))

        val data = Common.inputStreamToString(context.resources.openRawResource(R.raw.data))
        return Gson().fromJson(data, DataResponse::class.java)
    }
}