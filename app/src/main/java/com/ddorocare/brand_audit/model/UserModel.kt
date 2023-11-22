package com.ddorocare.brand_audit.model

data class UserModel(
    val token : String,
    val name: String,
    val username: String,
    val isLogin: Boolean,
    val role : String = "",
)

enum class Role (val value : String) {
    USER ("user"), ADMIN ("admin"), SUPERADMIN("superadmin")
}

