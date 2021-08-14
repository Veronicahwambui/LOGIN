package com.example.codehiveregestrationtwo.api

import com.example.codehiveregestrationtwo.models.Loginrequest
import com.example.codehiveregestrationtwo.models.Loginrespond
import com.example.codehiveregestrationtwo.models.Registrationrequest
import com.example.codehiveregestrationtwo.models.Registrationrespond
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST( "/student/register ")
   suspend fun registerstudent(@Body registrationrequest: Registrationrequest):Response<Registrationrespond>

    @POST("/student/login")
    suspend fun loginstudent(@Body loginrequest: Loginrequest):Response<Loginrespond>
}
