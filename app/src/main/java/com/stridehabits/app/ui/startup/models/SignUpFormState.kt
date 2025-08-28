package com.stridehabits.app.ui.startup.models

import com.stridehabits.app.core.models.FormField

data class SignUpFormState(
    val name: FormField<String>,
    val surname: FormField<String>,
    val identity: FormField<String>,
    val passwordDefault: FormField<String>,
    val passwordConfirm: FormField<String>,
)