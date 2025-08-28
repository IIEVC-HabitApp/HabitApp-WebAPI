package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias ExcludeNumbers = ExcludeNumbersStringValidationLaw

class ExcludeNumbersStringValidationLaw : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        return when (value.any { it.isDigit() }) {
            true -> ValidationError.String.EXCLUDE_NUMBERS
            else -> null
        }
    }
}