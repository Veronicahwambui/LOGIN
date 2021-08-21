package com.example.codehiveregestrationtwo.viewmodel




    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.example.codehiveregestrationtwo.models.EnrolmentResponse
    import com.example.codehiveregestrationtwo.respository.CoursesRepository
    import kotlinx.coroutines.launch

    class EnrolViewModel: ViewModel() {
        var enrolLiveData = MutableLiveData<EnrolmentResponse>()
        var enrolmentError = MutableLiveData<String>()
        var coursesRepository = CoursesRepository()

        fun enrol(accessToken: String){
            viewModelScope.launch {
                var response = coursesRepository.enroll(accessToken)
                if (response.isSuccessful){
                    enrolLiveData.postValue(response.body())
                }
                else{
                    enrolmentError.postValue(response.errorBody()?.string())
                }
            }
        }
    }
