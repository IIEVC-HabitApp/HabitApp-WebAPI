package com.stridehabits.app.core.validations.statutes

import com.stridehabits.app.core.validations.ValidationError

fun interface ValidationLaw<T> {
    fun checkFor(value: T): ValidationError?
}