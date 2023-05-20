package mobile.android.partthree.model

import com.google.gson.annotations.SerializedName

data class DataResponse(

	@field:SerializedName("DataResponse")
	val dataResponse: List<DataResponseItem>
)