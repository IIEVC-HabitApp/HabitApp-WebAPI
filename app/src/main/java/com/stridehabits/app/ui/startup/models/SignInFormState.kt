package com.stridehabits.app.ui.startup.models

import com.stridehabits.app.core.models.FormField

data class SignInFormState(
    val identity: FormField<String>,
    val password: FormField<String>,
)