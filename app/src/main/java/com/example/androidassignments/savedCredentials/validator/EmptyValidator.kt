package com.example.androidassignments.savedCredentials.validator

import com.example.androidassignments.R
import com.example.androidassignments.savedCredentials.validator.base.BaseValidator
import com.example.androidassignments.savedCredentials.validator.base.ValidateResult

class EmptyValidator(private val input:String) :BaseValidator(){
    override fun validate(): ValidateResult {
        val isValid=input.isNotEmpty()
        return ValidateResult(
            isValid,
            if(isValid) R.string.text_validation_success
            else R.string.field_is_empty
        )
    }
}