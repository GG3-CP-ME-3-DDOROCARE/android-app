package com.ddorocare.brand_audit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ddorocare.brand_audit.model.LoginRequest
import com.ddorocare.brand_audit.model.User


class Repository {

    fun login (loginRequest : LoginRequest) : LiveData<ResultCustom<User>> = liveData{
        emit(ResultCustom.Loading)
        try {
            val response = ApiConfig.getApiService().login(loginRequest)
            Log.d("hasil respons", "${response.user}")
            if (response.user != null){
                emit (ResultCustom.Success(response.user))
            } else {
                emit(ResultCustom.Error(response.message ?: "invalid user"))
            }
        } catch (exception : Exception){
            Log.d("hasil respons", "${exception.message}")
            emit(ResultCustom.Error(exception.message ?: "unknown erro"))
        }
    }
}