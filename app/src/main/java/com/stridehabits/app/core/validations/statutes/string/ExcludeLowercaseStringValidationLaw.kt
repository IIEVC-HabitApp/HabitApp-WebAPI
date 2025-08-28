package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias ExcludeLowercase = ExcludeLowercaseStringValidationLaw

class ExcludeLowercaseStringValidationLaw : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        return when (value.any { it.isLowerCase() }) {
            true -> ValidationError.String.EXCLUDE_LOWERCASE
            else -> null
        }
    }
}