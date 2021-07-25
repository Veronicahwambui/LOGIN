package com.example.codehiveregestrationtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class courseactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courseactivity)
        var rvCourses=findViewById<RecyclerView>(R.id.rvcourses)
        var courseList= listOf(
            Course("MB101","Mobile Development","Introduction to Android  development with kotlin","John Owour"),
            Course("MB101","Backend Development","Introduction to Backend development with python","James Mwai"),
            Course("MB101","Frontend Development","Introduction to Frontend development with javascript","Purity Mwai"),
            Course("MB101","Industrial Design","Design everyday in Fusion studio","Barrier"),
            Course("MB101","UX research","Introduction to Android development with python","Joy Wambui"),
            Course("MB12","Enterprenuership","Introduction of Startup company","Velma Mercy")

        )

        var courseAdapter=CourseAdapter(courseList)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=courseAdapter


    }
}