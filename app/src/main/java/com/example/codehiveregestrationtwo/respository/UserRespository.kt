package com.example.codehiveregestrationtwo.respository


import com.example.codehiveregestrationtwo.api.ApiClient
import com.example.codehiveregestrationtwo.api.ApiInterface
import com.example.codehiveregestrationtwo.models.Loginrequest
import com.example.codehiveregestrationtwo.models.Loginrespond
import com.example.codehiveregestrationtwo.models.Registrationrequest
import com.example.codehiveregestrationtwo.models.Registrationrespond
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call


import retrofit2.Response

class UserRespository {
     val apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
     suspend fun registerstudent(registrationRequest: Registrationrequest): Response<Registrationrespond> {
         return withContext(Dispatchers.IO){
             var response=apiInterface.registerstudent(registrationRequest)
             return@withContext response
         }
     }
    suspend fun loginstudent(Loginrequest:Loginrequest): Response<Loginrespond>
    = withContext(Dispatchers.IO){
        var response=apiInterface.loginstudent(Loginrequest)
        return@withContext response
    }

 }