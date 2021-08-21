package com.example.codehiveregestrationtwo.ui

import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("course_Id")var courseId: String,

    var courseName :String,
    var description:String,
    var instructor:String,
    var courseCode:String

)
