package com.stridehabits.app.ui.startup.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.stridehabits.app.databinding.ActivityLockBinding
import com.stridehabits.app.ui.startup.viewmodels.LockViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LockActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LockActivity"
    }


// --- Fields


    private lateinit var binds: ActivityLockBinding
    private val model: LockViewModel by viewModels()


// --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBindings()
        setupLayoutUi()
    }


// --- UI


    private fun setupBindings() {
        binds = ActivityLockBinding.inflate(layoutInflater)
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