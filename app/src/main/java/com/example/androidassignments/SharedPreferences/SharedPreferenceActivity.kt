package com.example.androidassignments.SharedPreferences

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySharedPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref=getSharedPreferences("signInData", MODE_PRIVATE)

        binding.editTextText11.text= sharedPref.getString("Email",null)?.toEditable()
        binding.editTextTextPassword2.text=sharedPref.getString("Password",null)?.toEditable()

        binding.button22.setOnClickListener {
            if (binding.editTextText11.text?.isNotBlank() == true && binding.editTextTextPassword2.text?.isNotBlank() ==true) {
                sharedPref.edit().apply{
                    putString("Email",binding.editTextText11.text.toString())
                    putString("Password",binding.editTextTextPassword2.text.toString())
                    apply()
                    Toast.makeText(this@SharedPreferenceActivity, "Login Data saved", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}