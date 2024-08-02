package com.example.androidassignments.dataPersistence

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivityCourseBinding
import com.example.androidassignments.databinding.CustomCourseDailogBinding
import kotlinx.coroutines.runBlocking

class CourseActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCourseBinding
    private var newCourse:Course?=null
    private lateinit var appDb:CourseDataBase
    private lateinit var dataSet:LiveData<List<Course>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        appDb=CourseDataBase.getDataBase(this)


        dataSet =appDb.courseDoa().getAllCourses()



        dataSet.observe(this, Observer {
            binding.imageView6.isVisible=false
            if(dataSet.value!!.isNotEmpty()){
                binding.textView28.isVisible=false
            }else{
                binding.textView28.isVisible=true
            }
            val linearRvAdapter= CourseRvAdapter(dataSet.value!!,appDb,this)
            val recyclerView=binding.recyclerView3
            recyclerView.adapter=linearRvAdapter
            recyclerView.layoutManager= LinearLayoutManager(this)
        })

        binding.floatingActionButton.setOnClickListener{
            showDialogBox(null)
        }
    }


     fun showDialogBox(course:Course?){
        val dialog= Dialog(this)
        val dialogView= LayoutInflater.from(this).inflate(R.layout.custom_course_dailog,null)
        dialog.setContentView(dialogView)
         
         val window = dialog.window
         if (window != null) {
             val layoutParams = WindowManager.LayoutParams()
             layoutParams.copyFrom(window.attributes)
             layoutParams.width = 900
             layoutParams.height = 1500
             window.attributes = layoutParams
         }

         dialog.show()

        val buttonView=dialogView.findViewById<Button>(R.id.button21)
        val crsName=dialogView.findViewById<TextView>(R.id.editTextText7)
        val crsDesc=dialogView.findViewById<TextView>(R.id.editTextText8)
        val crsDur=dialogView.findViewById<TextView>(R.id.editTextText9)
        val crsTrack=dialogView.findViewById<TextView>(R.id.editTextText10)
        val crsButton=dialogView.findViewById<Button>(R.id.button21)

        if(course!=null){
            crsName.text=course.courseName
            crsDur.text=course.courseDuration
            crsTrack.text=course.courseTracks
            crsDesc.text=course.courseDescription
            crsButton.text="Update"
        }else{
            crsButton.text="Add"
        }
        buttonView.setOnClickListener {
            if(crsName.text.isBlank() || crsDesc.text.isBlank() ||crsDur.text.isBlank() || crsTrack.text.isBlank()){
                //Show red line to fill complete data
            }else{
                 newCourse=Course(courseName = crsName.text.toString(), courseDescription = crsDesc.text.toString(),
                    courseTracks = crsTrack.text.toString(), courseDuration = crsDur.text.toString())

                dialog.dismiss()
                runBlocking {
                    if(course!=null){
                        newCourse!!.id=course.id
                        appDb.courseDoa().updateCourse(newCourse!!)
                    } else if(newCourse!=null)
                        appDb.courseDoa().insertCourse(newCourse!!) else TODO()
                }
            }
        }
    }
}