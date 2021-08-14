package com.example.codehiveregestrationtwo.models

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class Registrationrespond (
     var name:String,
        @SerializedName("phone_number")var phoneNumber:String,
     var email: String ,
     @SerializedName("date_of_birth") var dateOfBirth:String,
     var nationality:String,
     var password:String,
     @SerializedName("student_id") var studentId:String


         )