package com.example.codehiveregestrationtwo.respository


import com.example.codehiveregestrationtwo.api.ApiClient
import com.example.codehiveregestrationtwo.api.ApiInterface
import com.example.codehiveregestrationtwo.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call


import retrofit2.Response

class UserRespository {
     val apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
     suspend fun registerstudent(registrationRequest: Registrationrequest): Response<Registrationrespond>
         = withContext(Dispatchers.IO){
             var response=apiInterface.registerstudent(registrationRequest)
             return@withContext response
         }

    suspend fun enrol(accessToken: String): Response<EnrolmentResponse> =
        withContext(Dispatchers.IO){
            var enrol = apiInterface.enrol(accessToken)
            return@withContext enrol
        }
     }
