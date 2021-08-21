package com.example.codehiveregestrationtwo.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregestrationtwo.CoursesResponse

import com.example.codehiveregestrationtwo.respository.CoursesRepository
import kotlinx.coroutines.launch

class CoursesViewModel: ViewModel() {
    var coursesLiveData = MutableLiveData<List<CoursesResponse>>()
    var coursesFailedLiveData = MutableLiveData<String>()
    var coursesRepository = CoursesRepository()

    fun coursesList(accessToken: String){
        viewModelScope.launch {
            var response = coursesRepository.Course(accessToken)
            if (response.isSuccessful){
                coursesLiveData.postValue(response.body())
            }
            else{
                coursesFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}