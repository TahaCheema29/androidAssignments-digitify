package com.example.androidassignments.dataPersistence

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignments.databinding.CourseRvItemBinding
import kotlinx.coroutines.runBlocking

class CourseRvAdapter(private var dataSet:List<Course>,private var appDb:CourseDataBase,private val activity: CourseActivity):
    RecyclerView.Adapter<CourseRvAdapter.ViewHolder>() {

        private lateinit var binding:CourseRvItemBinding
        class ViewHolder(var view:CourseRvItemBinding):RecyclerView.ViewHolder(view.root){
/*            val crsNameView:TextView=view.findViewById(R.id.textView24)
            val crsTrackView:TextView=view.findViewById(R.id.textView25)
            val crsDesView:TextView=view.findViewById(R.id.textView26)
            val crsDayView:TextView=view.findViewById(R.id.textView27)
            val crsIdView:TextView=view.findViewById(R.id.textView29)
            val crsDelete:ImageButton=view.findViewById(R.id.imageButton)
            val crsUpdate:ImageButton=view.findView.ById(R.id.imageButton2)*/
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding= CourseRvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int{

        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      /*  try {

            holder.crsIdView.text=dataSet[position].id.toString()+"."
            holder.crsNameView.text=dataSet[position].courseName
            holder.crsTrackView.text= dataSet[position].courseTracks+" tracks"
            holder.crsDesView.text=dataSet[position].courseDescription
            holder.crsDayView.text= dataSet[position].courseDuration+ " Days"
        }catch (e:NullPointerException){
            Log.d("TAG","AT HOLDER")
        }*/


        holder.view.model=dataSet[position]

        holder.view.imageButton.setOnClickListener{
            runBlocking {
                appDb.courseDoa().deleteCourse(Course(
                    id = dataSet[position].id, courseName = dataSet[position].courseName,
                    courseDuration = dataSet[position].courseDuration, courseTracks = dataSet[position].courseTracks,
                    courseDescription = dataSet[position].courseDescription
                ))
            }
        }
        holder.view.imageButton2.setOnClickListener{
            activity.showDialogBox(Course(
                id = dataSet[position].id, courseName = dataSet[position].courseName,
                courseDuration = dataSet[position].courseDuration, courseTracks = dataSet[position].courseTracks,
                courseDescription = dataSet[position].courseDescription
            ))
        }

    }

}