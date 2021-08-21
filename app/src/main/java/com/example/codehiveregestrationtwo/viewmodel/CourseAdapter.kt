package com.example.codehiveregestrationtwo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregestrationtwo.ui.Course

class CourseAdapter(var courseList:List<Course>) :RecyclerView.Adapter<CourseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.course_list_item,parent,false)
        return CourseViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        var currentCourse=courseList.get(position)
        holder.tvcourseName.text=currentCourse.courseName
        holder.tvdescription.text=currentCourse.description
        holder.tvinstructor.text=currentCourse.instructor
        holder.tvcourseCode.text=currentCourse.courseCode
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class  CourseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvcourseName =itemView.findViewById<TextView>(R.id.tvcourseName )
    var tvdescription=itemView.findViewById<TextView>(R.id.tvDescription)
    var tvinstructor=itemView.findViewById<TextView>(R.id.tvinstructor)
    var tvcourseCode=itemView.findViewById<TextView>(R.id.tvcode)
}