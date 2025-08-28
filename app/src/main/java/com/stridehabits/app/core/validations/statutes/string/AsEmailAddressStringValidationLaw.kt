package com.stridehabits.app.core.validations.statutes.string

import android.util.Patterns
import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias AsEmailAddress = AsEmailAddressStringValidationLaw

class AsEmailAddressStringValidationLaw : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        return when (Patterns.EMAIL_ADDRESS.matcher(value).matches().not()) {
            true -> ValidationError.String.INVALID_EMAIL_ADDRESS
            else -> null
        }
    }
}