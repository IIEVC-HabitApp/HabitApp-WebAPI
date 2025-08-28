package com.stridehabits.app.ui.central.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeOptionViewModel @Inject constructor() : ViewModel() {
    companion object {
        private const val TAG = "HomeOptionViewModel"
    }
}