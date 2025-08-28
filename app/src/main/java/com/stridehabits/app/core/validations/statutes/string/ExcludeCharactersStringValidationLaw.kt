package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias ExcludeCharacters = ExcludeCharactersStringValidationLaw

class ExcludeCharactersStringValidationLaw(
    vararg val characters: Char
) : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        return when (value.any { it in characters }) {
            true -> ValidationError.String.EXCLUDE_CUSTOM_CHARACTERS
            else -> null
        }
    }
}