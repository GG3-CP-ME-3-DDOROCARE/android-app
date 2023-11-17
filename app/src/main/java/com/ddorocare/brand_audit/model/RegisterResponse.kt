package com.ddorocare.brand_audit.model

import com.google.gson.annotations.SerializedName


data class RegisterRequest(
	@SerializedName("full_name")
	val fullName: String,

	@SerializedName("username")
	val username: String,

	@SerializedName("password")
	val password: String,

	@SerializedName("password_check")
	val passwordCheck : String
)


data class RegisterResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val userRegister: UserRegister? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class UserRegister(

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
