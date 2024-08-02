package com.example.androidassignments.savedCredentials

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidassignments.R
import com.example.androidassignments.databinding.FragmentLoginScreenBinding
import com.example.androidassignments.savedCredentials.validator.EmptyValidator
import com.example.androidassignments.savedCredentials.validator.PasswordValidator
import com.example.androidassignments.savedCredentials.validator.base.BaseValidator

class LoginScreenFragment : Fragment() {

    private var _binding:FragmentLoginScreenBinding?=null
    private val binding get()=_binding!!
    private lateinit var tokenManager: TokenManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        tokenManager= TokenManager(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding=FragmentLoginScreenBinding.inflate(inflater)
        if(tokenManager.getToken()!=null){
            findNavController().navigate(R.id.action_loginScreenFragment_to_mainScreenFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {

            val txtUserName = binding.inputEditTextUsername.text.toString()
            val txtUserPass = binding.inputEditTextPassword.text.toString()

            val userNameLayout = binding.inputLayoutUsername
            val passwordLayout = binding.inputEditTextPassword

            val userNameEmptyValidation = EmptyValidator(txtUserName).validate()
            userNameLayout.error =
                if (!userNameEmptyValidation.isSuccess) {
                    getString(userNameEmptyValidation.message)
                } else {
                    null
                }

            val passwordValidator =
                BaseValidator.validate(EmptyValidator(txtUserPass), PasswordValidator(txtUserPass))
            passwordLayout.error =
                if (!passwordValidator.isSuccess) {
                    getString(passwordValidator.message)
                } else {
                    null
                }

            if (userNameLayout.error == null && passwordLayout.error == null) {
                tokenManager.savedToken(UserData(txtUserName, txtUserPass))
                findNavController().navigate(R.id.action_loginScreenFragment_to_mainScreenFragment)
            }
        }
    }

}