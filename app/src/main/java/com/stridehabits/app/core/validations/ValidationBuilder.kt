package com.stridehabits.app.core.validations

import com.stridehabits.app.core.models.results.Final
import com.stridehabits.app.core.validations.statutes.ValidationLaw

class ValidationBuilder<T> private constructor(
    private val valueToValidate: T
) {
    companion object {
        private const val TAG = "ValidationBuilder"

        // --- Extensions

        fun forString(value: String) = ValidationBuilder(value)
        fun forNumber(value: Number) = ValidationBuilder(value)
    }


// --- Validation


    val laws = mutableListOf<ValidationLaw<T>>()


    fun register(law: ValidationLaw<T>) = apply {
        laws.add(law)
    }


    fun validate(): Final<Unit, ValidationError> {
        for (rule in laws) {
            val violation = rule.checkFor(valueToValidate)
            violation?.let { error ->
                return Final.Failure(error)
            }
        }

        return Final.Success(Unit)
    }
}