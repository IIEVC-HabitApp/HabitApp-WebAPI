package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias IncludeSymbols = IncludeSymbolsStringValidationLaw

class IncludeSymbolsStringValidationLaw(
    val min: Int = 1,
    val max: Int? = null,
) : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        if (max != null) {
            check(max >= min)
        }

        val limit = max ?: Int.MAX_VALUE
        val count = value.count { !(it.isLetterOrDigit()) }
        return when (count) {
            in (min..limit) -> null
            else -> {
                ValidationError.String.INCLUDE_SYMBOLS
            }
        }
    }
}