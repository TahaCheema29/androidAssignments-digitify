package com.example.androidassignments.savedCredentials.validator.base

import com.example.androidassignments.R

abstract class BaseValidator():IValidator {

    companion object {
        fun validate(vararg validator: IValidator): ValidateResult {
            validator.forEach {
                val result = it.validate()
                if (!result.isSuccess) {
                    return result
                }
            }
            return ValidateResult(true, R.string.text_validation_success)
        }
    }
}