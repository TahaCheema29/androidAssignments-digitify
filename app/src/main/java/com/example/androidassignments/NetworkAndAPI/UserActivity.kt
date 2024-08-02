package com.example.androidassignments.NetworkAndAPI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignments.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val retrofitService=UserInstance.retrofitInstance.create(UserService::class.java)

        val responseLiveData= liveData{
            val response=retrofitService.getUsers()
            emit(response)
        }

        responseLiveData.observe(this,Observer{
            if(it.body()!=null){
                binding.imageView7.isVisible=false
                val linearRvAdapter=UserRvAdapter(it.body()!!)
                val recyclerView=binding.recyclerView4
                recyclerView.adapter=linearRvAdapter
                recyclerView.layoutManager=LinearLayoutManager(this)
            }
        })

    }
}