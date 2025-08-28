package com.stridehabits.app.ui.startup.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotCredentialsViewModel @Inject constructor() : ViewModel() {
    companion object {
        private const val TAG = "ForgotCredentialsViewModel"
    }


// --- Fields


    val form = ForgotCredentialsFormViewModel()
}