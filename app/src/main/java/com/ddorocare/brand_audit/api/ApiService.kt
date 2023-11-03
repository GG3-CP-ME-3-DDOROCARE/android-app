package com.ddorocare.brand_audit;


import com.ddorocare.brand_audit.model.LoginResponse
import com.ddorocare.brand_audit.model.LoginRequest
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse


}