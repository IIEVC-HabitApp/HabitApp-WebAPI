package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias ExcludeUppercase = ExcludeUppercaseStringValidationLaw

class ExcludeUppercaseStringValidationLaw : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        return when (value.any { it.isUpperCase() }) {
            true -> ValidationError.String.EXCLUDE_UPPERCASE
            else -> null
        }
    }
}