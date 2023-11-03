package com.ddorocare.brand_audit.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
	val username: String,
	val password: String
)


data class LoginResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class User(

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
