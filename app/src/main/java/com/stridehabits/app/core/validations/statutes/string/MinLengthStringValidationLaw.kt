package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias MinLength = MinLengthStringValidationLaw

class MinLengthStringValidationLaw(
    val length: Int
) : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        check(length >= 0)
        return when (value.length < length) {
            true -> ValidationError.String.REQUIRE_MIN_CHARS
            else -> null
        }
    }
}