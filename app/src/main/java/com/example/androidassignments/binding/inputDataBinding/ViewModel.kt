package com.example.androidassignments.binding.inputDataBinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel:ViewModel() {
    val liveData=MutableLiveData<String>()
    init{
        liveData.value="hey"
    }
}