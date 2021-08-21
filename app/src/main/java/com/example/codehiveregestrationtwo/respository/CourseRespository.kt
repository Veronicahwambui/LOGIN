package com.example.codehiveregestrationtwo.respository

import com.example.codehiveregestrationtwo.CoursesResponse
import com.example.codehiveregestrationtwo.api.ApiClient
import com.example.codehiveregestrationtwo.api.ApiInterface
import com.example.codehiveregistrationtwo.models.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoursesRepository {
    lateinit var sessionManager:SessionManager
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun getcourses(accessToken:String): Response<List<CoursesResponse>> =
        withContext(Dispatchers.IO){
            var response=apiInterface.getCourses(token="Bearer ${sessionManager.fetchAuthentication()}")
            return@withContext response

        }
}