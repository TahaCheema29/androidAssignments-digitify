package com.example.androidassignments.bindings

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivityBindingsBinding


class BindingsActivity : AppCompatActivity() {

    // TODO: make UI changes for rv item then add viewModel,LiveData and use dataBinding in xml file  
    private lateinit var binding:ActivityBindingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make status bar icons dark
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        binding=DataBindingUtil.setContentView(this,R.layout.activity_bindings)

        val codeArray=Array<RvModel?>(6){null}

        val rvAdapter=RvAdapter(codeArray,this)
        val recyclerView=binding.recyclerView2
        recyclerView.adapter=rvAdapter
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }
}