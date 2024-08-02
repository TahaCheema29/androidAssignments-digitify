package com.example.androidassignments.RecyclerViews.LinearRV

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivityLinearRvBinding

class LinearRvActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLinearRvBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLinearRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataSet= arrayOf(
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
            LinearRvModel(R.drawable.prof,R.string.title_name,R.string.description_name,R.string.date_info),
        )

        val linearRvAdapter= LinearRvAdapter(dataSet,this)
        val recyclerView=binding.recyclerView
        recyclerView.adapter=linearRvAdapter
        recyclerView.layoutManager=LinearLayoutManager(this)



    }
}