package com.example.codehiveregestrationtwo.module

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class Loginrespond(

    @SerializedName("access_token")var accessToken: String,
    @SerializedName("student_id") var studentId: String,
    var message:String,

)
