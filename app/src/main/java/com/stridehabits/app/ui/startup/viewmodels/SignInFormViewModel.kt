package com.stridehabits.app.ui.startup.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stridehabits.app.core.extensions.kotlin.emptyString
import com.stridehabits.app.core.models.FormField
import com.stridehabits.app.core.validations.statutes.string.AsEmailAddress
import com.stridehabits.app.core.validations.statutes.string.AsFirebaseCredential
import com.stridehabits.app.core.validations.statutes.string.ExcludeWhitespace
import com.stridehabits.app.core.validations.statutes.string.NotEmpty
import com.stridehabits.app.ui.shared.models.ValidatableForm
import com.stridehabits.app.ui.startup.models.SignInFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignInFormViewModel @Inject constructor() : ViewModel(), ValidatableForm {
    companion object {
        private const val TAG = "SignInFormViewModel"
    }


// --- Internals


    private val schema = SignInFormState(
        identity = FormField(
            value = emptyString(), //
            rules = listOf(
                NotEmpty(), ExcludeWhitespace(), AsEmailAddress()
            )
        ), //
        password = FormField(
            value = emptyString(), //
            rules = listOf(
                NotEmpty(), AsFirebaseCredential()
            )
        )
    )


    private val _state = MutableStateFlow(schema)
    val state = _state.asStateFlow()


// --- Functions


    fun onIdentityChanged(
        value: String
    ) {
        _state.update { current ->
            current.copy(
                identity = current.identity.copy(value = value).applyValidation()
            )
        }
    }
    

    fun onPasswordChanged(
        value: String
    ) {
        _state.update { current ->
            current.copy(
                password = current.password.copy(value = value).applyValidation()
            )
        }
    }


// --- Validation


    override val isFormValid = state.map { field ->
        listOf(
            field.identity, field.password
        ).all {
            it.isValid
        }
    }.stateIn(
        viewModelScope, SharingStarted.Eagerly, false
    )


    override fun validateForm() {
        _state.update { current ->
            current.copy(
                identity = current.identity.applyValidation(),
                password = current.password.applyValidation(),
            )
        }
    }
}