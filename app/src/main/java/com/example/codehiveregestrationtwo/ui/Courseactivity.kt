package com.example.codehiveregestrationtwo.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregestrationtwo.Consants
import com.example.codehiveregestrationtwo.CourseAdapter
import com.example.codehiveregestrationtwo.CourseViewHolder
import com.example.codehiveregestrationtwo.R
import com.example.codehiveregestrationtwo.databinding.ActivityLoginBinding

class courseactivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val courseViewModel: CourseViewHolder by viewModels()
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=getSharedPreferences("Sharedprefrencers", Context.MODE_PRIVATE)



    }


    override fun onResume() {
        super.onResume()
        var accesstoken=sharedPreferences.getString(Consants.ACCESS_TOKEN, Consants.EMPTY_STRING)

//        To  do :log user out if access is empty
        var bearer="Bearer$accesstoken"

        if ( accesstoken!!.isNotEmpty()) {
            courseViewModel.getCourses(bearer)

            courseViewModel.coursesLiveData.observe(this) { courseList ->
            }
            courseViewModel.errorLiveData.observe(this) { error ->
                Toast.makeText()
            }
        }
        }



    }
}
//the code


//
//
//override fun onResume(){
//    super.onResume()
//    var accessToken = sharedPreferences.getString(Constants.toString(),"ACCESS_TOKEN")
////        var accessToken = sharedPreferences.getString(Constants.ACCESSTOKEN, Constants.EMPTY_STRING)
//    var bearer = "Bearer $accessToken"
//
//    //Log user out if access token is empty
//    //how to read shared preferences from the adapter
//    if (accessToken!!.isNotEmpty()){
//        coursesViewModel.coursesList(accessToken)
//    }
//    else{
//        startActivity(Intent(baseContext, LogIn::class.java))
//    }
//    var rvCoursesResponseAdapter = binding.rvCourses
//    rvCoursesResponseAdapter.layoutManager = LinearLayoutManager(baseContext)
//    coursesViewModel.coursesLiveData.observe(this, {coursesList->
//
//        var coursesResponseAdapter = CoursesResponseAdapter(coursesList)
//        rvCoursesResponseAdapter.adapter = coursesResponseAdapter
//        Toast.makeText(baseContext, "${coursesList.size} courses fetched", Toast.LENGTH_LONG).show()
//    })
//    coursesViewModel.coursesFailedLiveData.observe(this, {
//            error->Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//    })
//}
//}
//
//the end




//var rvCourses=findViewById<RecyclerView>(R.id.rvcourses)
//var courseList= listOf(
//    Course("MB101","Mobile Development","Introduction to Android  development with kotlin","John Owour"),
//    Course("MB101","Backend Development","Introduction to Backend development with python","James Mwai"),
//    Course("MB101","Frontend Development","Introduction to Frontend development with javascript","Purity Mwai"),
//    Course("MB101","Industrial Design","Design everyday in Fusion studio","Barrier"),
//    Course("MB101","UX research","Introduction to Android development with python","Joy Wambui"),
//    Course("MB12","Enterprenuership","Introduction of Startup company","Velma Mercy")
//
//)
//
//var courseAdapter= CourseAdapter(courseList)
//rvCourses.layoutManager=LinearLayoutManager(baseContext)
//rvCourses.adapter=courseAdapter