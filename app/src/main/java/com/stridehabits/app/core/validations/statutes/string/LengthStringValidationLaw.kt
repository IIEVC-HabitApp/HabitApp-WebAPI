package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias Length = LengthStringValidationLaw

class LengthStringValidationLaw(
    val min: Int,
    val max: Int,
) : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        check(max >= min)
        MinLength(min).checkFor(value)?.let { return it }
        MaxLength(max).checkFor(value)?.let { return it }
        return null
    }
}