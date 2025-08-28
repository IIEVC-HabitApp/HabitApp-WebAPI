package com.stridehabits.app.ui.startup.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LockViewModel @Inject constructor(): ViewModel() {
    companion object {
        private const val TAG = "LockViewModel"
    }
}