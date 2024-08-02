package com.example.androidassignments.Fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button7.setOnClickListener {
            val manager=supportFragmentManager
            val tr=manager.beginTransaction()
            tr.replace(R.id.frameLayout2,BlankFragment())
            tr.commit()
        }
        binding.button15.setOnClickListener {
            val manager=supportFragmentManager
            val tr=manager.beginTransaction()
            tr.replace(R.id.frameLayout2,BlankFragment2())
            tr.commit()
        }
        binding.button17.setOnClickListener {
            val manager=supportFragmentManager
            val tr=manager.beginTransaction()
            tr.replace(R.id.frameLayout2,BlankFragment3())
            tr.commit()
        }
    }
}