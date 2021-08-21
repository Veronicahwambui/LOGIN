package com.example.codehiveregestrationtwo.api

import com.example.codehiveregestrationtwo.CoursesResponse
import com.example.codehiveregestrationtwo.models.*
import com.example.codehiveregestrationtwo.ui.Course
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/student/register ")
    suspend fun registerstudent(@Body registrationrequest: Registrationrequest): Response<Registrationrespond>

    @POST("/student/login")
    suspend fun loginstudent(@Body loginrequest: Loginrequest): Response<Loginrespond>

    @GET("/courses")
    suspend fun getCourses(@Header("Authorization") token: String): Response<List<CoursesResponse>>

    @POST("/enrolments")
    suspend fun enrol(@Header("Authorization") token: String): Response<EnrolmentResponse>

}