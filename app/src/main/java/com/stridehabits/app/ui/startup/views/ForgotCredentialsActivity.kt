package com.stridehabits.app.ui.startup.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.stridehabits.app.databinding.ActivityForgotCredentialsBinding
import com.stridehabits.app.ui.startup.viewmodels.ForgotCredentialsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ForgotCredentialsActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "ForgotCredentialsActivity"
    }


// --- Fields


    private lateinit var binds: ActivityForgotCredentialsBinding
    private val model: ForgotCredentialsViewModel by viewModels()


// --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBindings()
        setupLayoutUi()
        setupForm()
    }


// --- UI


    private fun setupForm() {
        // TODO: Collect text updates and call listeners

        // Error UI
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                model.form.state.collect { state ->
                    // TODO: Update error states in the UI
                }
            }
        }
    }


    private fun setupBindings() {
        binds = ActivityForgotCredentialsBinding.inflate(layoutInflater)
    }


    private fun setupLayoutUi() {
        enableEdgeToEdge()
        setContentView(binds.root)
        ViewCompat.setOnApplyWindowInsetsListener(binds.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}