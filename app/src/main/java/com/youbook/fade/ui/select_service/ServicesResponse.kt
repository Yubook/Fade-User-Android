package com.youbook.fade.ui.select_service

import com.google.gson.annotations.SerializedName

data class ServicesResponse(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ResultItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("required_time")
	val requiredTime: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
