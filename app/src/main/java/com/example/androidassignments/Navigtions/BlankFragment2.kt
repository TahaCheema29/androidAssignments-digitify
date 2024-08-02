package com.example.androidassignments.Navigtions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.androidassignments.R
import com.example.androidassignments.databinding.FragmentBlank5Binding

class BlankFragment2 : Fragment() {

    private lateinit var binding: FragmentBlank5Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val name= arguments?.getString("name")
        val email=arguments?.getString("email")
        val gender=arguments?.getString("gender")

        binding=FragmentBlank5Binding.inflate(inflater,container,false)

        binding.textView13.text = name
        binding.textView15.text=email
        binding.textView17.text=gender

        binding.button19.setOnClickListener {

            val bundle=Bundle().apply {
                putString("name",name)
                putString("email",email)
                putString("gender",gender)
            }

            Navigation.findNavController(binding.root).navigate(R.id.NavigateToFirstFragment,bundle)
        }
        return binding.root
    }
}