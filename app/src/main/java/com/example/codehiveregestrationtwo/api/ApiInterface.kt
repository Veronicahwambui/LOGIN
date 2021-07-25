package com.example.codehiveregestrationtwo.api

import com.example.codehiveregestrationtwo.module.Loginrequest
import com.example.codehiveregestrationtwo.module.Loginrespond
import com.example.codehiveregestrationtwo.module.Registrationrequest
import com.example.codehiveregestrationtwo.module.Registrationrespond
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @POST( "/student/register ")
    fun registerstudent(@Body registrationrequest:Registrationrequest):Call<Registrationrespond>

    @POST("/student/login")
    fun loginstudent(@Body loginrequest:Loginrequest):Call<Loginrespond>
}
