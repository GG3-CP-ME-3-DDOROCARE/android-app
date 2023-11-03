package com.ddorocare.brand_audit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ddorocare.brand_audit.model.LoginRequest
import com.ddorocare.brand_audit.model.User

class LoginViewModel () : ViewModel(){
    private val repository : Repository = Repository()
    fun login(loginRequest: LoginRequest) : LiveData<ResultCustom<User>>{
        return repository.login(loginRequest)
    }
}