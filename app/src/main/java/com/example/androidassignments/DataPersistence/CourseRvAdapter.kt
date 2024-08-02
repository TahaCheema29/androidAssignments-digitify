package com.example.androidassignments.DataPersistence

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignments.R
import kotlinx.coroutines.runBlocking
import org.w3c.dom.Text

class CourseRvAdapter(private var dataSet:List<Course>,private var appDb:CourseDataBase,private val activity: CourseActivity):
    RecyclerView.Adapter<CourseRvAdapter.ViewHolder>() {
        
        class ViewHolder(view:View):RecyclerView.ViewHolder(view){
            val crsNameView:TextView=view.findViewById(R.id.textView24)
            val crsTrackView:TextView=view.findViewById(R.id.textView25)
            val crsDesView:TextView=view.findViewById(R.id.textView26)
            val crsDayView:TextView=view.findViewById(R.id.textView27)
            val crsIdView:TextView=view.findViewById(R.id.textView29)
            val crsDelete:ImageButton=view.findViewById(R.id.imageButton)
            val crsUpdate:ImageButton=view.findViewById(R.id.imageButton2)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.course_rv_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int{

        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {

            holder.crsIdView.text=dataSet[position].id.toString()+"."
            holder.crsNameView.text=dataSet[position].courseName
            holder.crsTrackView.text= dataSet[position].courseTracks+" tracks"
            holder.crsDesView.text=dataSet[position].courseDescription
            holder.crsDayView.text= dataSet[position].courseDuration+ " Days"
        }catch (e:NullPointerException){
            Log.d("TAG","AT HOLDER")
        }

        holder.crsDelete.setOnClickListener{
            runBlocking {
                appDb.courseDoa().deleteCourse(Course(
                    id = dataSet[position].id, courseName = dataSet[position].courseName,
                    courseDuration = dataSet[position].courseDuration, courseTracks = dataSet[position].courseTracks,
                    courseDescription = dataSet[position].courseDescription
                ))
            }
        }
        holder.crsUpdate.setOnClickListener{
            activity.showDialogBox(Course(
                id = dataSet[position].id, courseName = dataSet[position].courseName,
                courseDuration = dataSet[position].courseDuration, courseTracks = dataSet[position].courseTracks,
                courseDescription = dataSet[position].courseDescription
            ))
        }

    }

}