package com.ddorocare.brand_audit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddorocare.brand_audit.model.*
import kotlinx.coroutines.launch

class LoginViewModel (private val pref: UserPreference) : ViewModel(){
    private val repository : Repository = Repository()
    fun login(loginRequest: LoginRequest) : LiveData<ResultCustom<UserLogin>>{
        return repository.login(loginRequest)
    }

    fun saveUser(user : UserModel){
        viewModelScope.launch {
            pref.saveUser(user)
        }
    }

    fun saveLogin(token : String){
        viewModelScope.launch {
            pref.login(token)
        }
    }

    fun logout (){
        viewModelScope.launch {
            pref.logout()
        }
    }
}