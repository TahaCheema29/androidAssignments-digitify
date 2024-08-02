package com.example.androidassignments.binding.inputDataBinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidassignments.R
import com.example.androidassignments.binding.inputDataBinding.ViewModel
import com.example.androidassignments.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    lateinit var binding:ActivityInputBinding
    private val viewModel:ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_input)

        binding.model=viewModel
        binding.lifecycleOwner=this
    }
}