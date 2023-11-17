package com.ddorocare.brand_audit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddorocare.brand_audit.model.LoginRequest
import com.ddorocare.brand_audit.model.Role
import com.ddorocare.brand_audit.model.UserLogin
import com.ddorocare.brand_audit.model.UserPreference
import kotlinx.coroutines.launch

class LoginViewModel (private val pref: UserPreference) : ViewModel(){
    private val repository : Repository = Repository()
    fun login(loginRequest: LoginRequest) : LiveData<ResultCustom<UserLogin>>{
        Role.ADMIN.value
        return repository.login(loginRequest)
    }

    fun saveLogin(token : String){
        viewModelScope.launch {
            pref.login(token)
        }
    }
}