package com.example.androidassignments.counterApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivityCounterAppBinding

class CounterAppActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCounterAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dataModel=DataModel(0)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_counter_app)

        binding.button20.setOnClickListener {
            dataModel.number++
            binding.model=dataModel
        }
    }
}