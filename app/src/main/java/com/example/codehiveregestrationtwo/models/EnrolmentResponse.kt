package com.example.codehiveregestrationtwo.models


import com.google.gson.annotations.SerializedName

data class EnrolmentResponse(
    @SerializedName("course_id") var courseId: String,
    @SerializedName("enrolment_id") var enrolmentId: String,
    var active: Boolean
)