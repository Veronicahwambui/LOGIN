package com.example.codehiveregestrationtwo.respository

import com.example.codehiveregestrationtwo.api.ApiClient
import com.example.codehiveregestrationtwo.api.ApiInterface
import com.example.codehiveregestrationtwo.models.Loginrequest
import com.example.codehiveregestrationtwo.models.Loginrespond
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRespository{
    var apiInterface=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginstudent(loginrequest: Loginrequest): Response<Loginrespond>
        = withContext(Dispatchers.IO){
         var response=apiInterface.loginstudent(loginrequest)
            return@withContext response
        }



    }
