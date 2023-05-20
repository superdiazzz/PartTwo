package mobile.android.partthree.model

import com.google.gson.annotations.SerializedName

data class DataResponseItem(

	@field:SerializedName("firstName")
	val firstName: String,

	@field:SerializedName("lastName")
	val lastName: String,

	@field:SerializedName("dob")
	val dob: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("email")
	val email: String
)