package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias ExcludeWhitespace = ExcludeWhitespaceStringValidationLaw

class ExcludeWhitespaceStringValidationLaw : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        return when (value.any { it.isWhitespace() }) {
            true -> ValidationError.String.EXCLUDE_WHITESPACE
            else -> null
        }
    }
}