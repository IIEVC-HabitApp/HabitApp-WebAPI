package com.stridehabits.app.ui.startup.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stridehabits.app.core.extensions.kotlin.emptyString
import com.stridehabits.app.core.models.FormField
import com.stridehabits.app.core.validations.statutes.string.AsEmailAddress
import com.stridehabits.app.core.validations.statutes.string.AsFirebaseCredential
import com.stridehabits.app.core.validations.statutes.string.ExcludeWhitespace
import com.stridehabits.app.core.validations.statutes.string.Length
import com.stridehabits.app.core.validations.statutes.string.NotEmpty
import com.stridehabits.app.ui.shared.models.ValidatableForm
import com.stridehabits.app.ui.startup.models.SignUpFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpFormViewModel @Inject constructor() : ViewModel(), ValidatableForm {
    companion object {
        private const val TAG = "SignUpFormViewModel"
    }


// --- Internals


    private val schema = SignUpFormState(
        name = FormField(
            value = emptyString(), //
            rules = listOf(
                Length(2, 32), ExcludeWhitespace()
            )
        ), //
        surname = FormField(
            value = emptyString(), //
            rules = listOf(
                Length(2, 64),
            )
        ), //
        identity = FormField(
            value = emptyString(), //
            rules = listOf(
                NotEmpty(), ExcludeWhitespace(), AsEmailAddress()
            )
        ), //
        passwordDefault = FormField(
            value = emptyString(), //
            rules = listOf(
                NotEmpty(), AsFirebaseCredential()
            )
        ), //
        passwordConfirm = FormField(
            value = emptyString(), //
            rules = listOf(
                NotEmpty(), AsFirebaseCredential()
            )
        )
    )


    private val _state = MutableStateFlow(schema)
    val state = _state.asStateFlow()


// --- Functions


    fun onNameChanged(
        value: String
    ) {
        _state.update { current ->
            current.copy(
                name = current.name.copy(value = value).applyValidation()
            )
        }
    }


    fun onSurnameChanged(
        value: String
    ) {
        _state.update { current ->
            current.copy(
                surname = current.surname.copy(value = value).applyValidation()
            )
        }
    }


    fun onIdentityChanged(
        value: String
    ) {
        _state.update { current ->
            current.copy(
                identity = current.identity.copy(value = value).applyValidation()
            )
        }
    }


    fun onPasswordDefaultChanged(
        value: String
    ) {
        _state.update { current ->
            current.copy(
                passwordDefault = current.passwordDefault.copy(value = value).applyValidation()
            )
        }
    }


    fun onPasswordConfirmChanged(
        value: String
    ) {
        _state.update { current ->
            current.copy(
                passwordConfirm = current.passwordConfirm.copy(value = value).applyValidation()
            )
        }
    }


// --- Validation


    override val isFormValid = state.map { field ->
        listOf(
            field.name,
            field.surname,
            field.identity,
            field.passwordDefault,
            field.passwordConfirm,
        ).all {
            it.isValid
        }
    }.stateIn(
        viewModelScope, SharingStarted.Eagerly, false
    )


    override fun validateForm() {
        _state.update { current ->
            current.copy(
                name = current.name.applyValidation(),
                surname = current.surname.applyValidation(),
                identity = current.identity.applyValidation(),
                passwordDefault = current.passwordDefault.applyValidation(),
                passwordConfirm = current.passwordConfirm.applyValidation(),
            )
        }
    }
}