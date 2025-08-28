package com.stridehabits.app.core.validations.statutes.string

import com.stridehabits.app.core.validations.ValidationError
import com.stridehabits.app.core.validations.statutes.ValidationLaw

typealias NotEmpty = NotEmptyStringValidationLaw

class NotEmptyStringValidationLaw : ValidationLaw<String> {
    override fun checkFor(value: String): ValidationError? {
        return MinLength(1).checkFor(value)
    }
}