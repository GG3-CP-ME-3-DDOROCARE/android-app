package com.ddorocare.brand_audit;


import com.ddorocare.brand_audit.model.GraphDetailResponse
import com.ddorocare.brand_audit.model.LoginRequest
import com.ddorocare.brand_audit.model.LoginResponse
import com.ddorocare.brand_audit.model.RegisterRequest
import com.ddorocare.brand_audit.model.RegisterResponse
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @POST("register")
    suspend fun register(
        @Body registerRequest: RegisterRequest
    ): RegisterResponse

    @GET("grafik")
    suspend fun getGraph(): List<GraphDetailResponse>

}