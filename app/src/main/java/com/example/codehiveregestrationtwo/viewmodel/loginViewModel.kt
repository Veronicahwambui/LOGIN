package com.example.codehiveregestrationtwo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregestrationtwo.models.Loginrequest
import com.example.codehiveregestrationtwo.models.Loginrespond
import com.example.codehiveregestrationtwo.respository.LoginRespository
import kotlinx.coroutines.launch

class  loginViewModel:ViewModel() {
    var loginLiveData = MutableLiveData<Loginrespond>()
    var loginFailedLiveData = MutableLiveData<String>()
    var LoginRespository =LoginRespository()

    fun login(loginrequest: Loginrequest) {
        viewModelScope.launch {

            var response=LoginRespository.loginstudent(loginrequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }else{
                loginFailedLiveData.postValue(response.errorBody()?.string())
            }

        }

    }
}