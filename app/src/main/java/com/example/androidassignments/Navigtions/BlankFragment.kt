package com.example.androidassignments.Navigtions

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.androidassignments.R
import com.example.androidassignments.databinding.FragmentBlank4Binding

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlank4Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentBlank4Binding.inflate(inflater, container, false)

        val genderArray= arrayOf("♂️ Male","♀️ Female")
        val arrayAdapter= ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,genderArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner2.adapter=arrayAdapter


        val name= arguments?.getString("name")
        val email=arguments?.getString("email")
        val gender=arguments?.getString("gender")

        binding.editTextText4.setText(name)
        binding.editTextText5.setText(email)

        var spinnerItem=""
        binding.spinner2.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent != null) {
                    spinnerItem= parent.getItemAtPosition(position).toString()
                }
                Log.d("TAG", spinnerItem)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.button18.setOnClickListener {
            if(binding.editTextText4.text.toString().isNotBlank() &&
                binding.editTextText5.text.toString().isNotBlank()){

                val bundle=Bundle().apply {
                    putString("name",binding.editTextText4.text.toString())
                    putString("email",binding.editTextText5.text.toString())
                    putString("gender",spinnerItem)

                }
                Navigation.findNavController(binding.root).navigate(R.id.NavigateToSecondFragment,bundle)
            }
        }
        return binding.root
    }

}