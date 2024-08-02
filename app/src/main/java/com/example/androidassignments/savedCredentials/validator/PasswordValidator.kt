package com.example.androidassignments.savedCredentials.validator

import com.example.androidassignments.R
import com.example.androidassignments.savedCredentials.validator.base.BaseValidator
import com.example.androidassignments.savedCredentials.validator.base.ValidateResult

class PasswordValidator(private val password:String):BaseValidator() {
    private val minPasswordLength=6
    private val maxPasswordLength=12

    override fun validate(): ValidateResult {
        if(password.length<minPasswordLength){
            return ValidateResult(false,
                R.string.text_validation_error_min_pass)
        }else if(password.length >maxPasswordLength){
            return ValidateResult(false,
                R.string.text_validation_error_max_pass)
        }else {
            return ValidateResult(true,
                R.string.text_validation_success)
        }
    }
}