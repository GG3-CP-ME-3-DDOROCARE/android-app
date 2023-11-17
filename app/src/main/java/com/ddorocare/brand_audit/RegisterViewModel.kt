package com.ddorocare.brand_audit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ddorocare.brand_audit.model.RegisterRequest
import com.ddorocare.brand_audit.model.RegisterResponse

class RegisterViewModel : ViewModel() {
    private val repository : Repository = Repository()

    fun register(request : RegisterRequest) : LiveData<ResultCustom<RegisterResponse>> {
        return repository.register(request)
    }
}