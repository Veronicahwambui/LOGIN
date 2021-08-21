package com.example.codehiveregestrationtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CourseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)
        var btnCourseDetails = findViewById<Button>(R.id.btnCourseDetails)
        btnCourseDetails.setOnClickListener {
            var intent = Intent(baseContext, LogIn::class.java)
            startActivity(intent)
        }




    }
}