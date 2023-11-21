package com.ddorocare.brand_audit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ddorocare.brand_audit.model.GraphDetailResponse
import com.ddorocare.brand_audit.model.LoginRequest
import com.ddorocare.brand_audit.model.RegisterRequest
import com.ddorocare.brand_audit.model.RegisterResponse
import com.ddorocare.brand_audit.model.UserLogin


class Repository {

    fun login(loginRequest: LoginRequest): LiveData<ResultCustom<UserLogin>> = liveData {
        emit(ResultCustom.Loading)
        try {
            val response = ApiConfig.getApiService().login(loginRequest)
            Log.d("hasil respons", "${response.userLogin}")
            if (response.userLogin != null) {
                emit(ResultCustom.Success(response.userLogin))
            } else {
                emit(ResultCustom.Error(response.message ?: "invalid user"))
            }
        } catch (exception: Exception) {
            Log.d("hasil respons", "${exception.message}")
            emit(ResultCustom.Error(exception.message ?: "unknown erro"))
        }
    }

    fun register(registerRequest: RegisterRequest): LiveData<ResultCustom<RegisterResponse>> =
        liveData {
            emit(ResultCustom.Loading)
            try {
                val response = ApiConfig.getApiService().register(registerRequest)
                Log.d("hasil respons", "${response.userRegister}")
                if (response.userRegister != null) {
                    emit(ResultCustom.Success(response))
                } else {
                    emit(ResultCustom.Error(response.message ?: "invalid user"))
                }
            } catch (exception: Exception) {
                Log.d("hasil respons", "${exception.message}")
                emit(ResultCustom.Error(exception.message ?: "unknown erro"))
            }
        }

    fun getGraphData(): LiveData<ResultCustom<List<GraphDetailResponse>>> = liveData {
        emit(ResultCustom.Loading)
        try {
            val response =
                ApiConfig.getGraphApiService().getGraph() // Adjust the method name as needed
            Log.d("GraphResponse", response.toString())
            emit(ResultCustom.Success(response)) // response is now a List<GraphDetailResponse>
        } catch (exception: Exception) {
            Log.e("GraphError", "Error: ${exception.message}")
            emit(ResultCustom.Error(exception.message ?: "Unknown error in fetching graph data"))
        }
    }
}