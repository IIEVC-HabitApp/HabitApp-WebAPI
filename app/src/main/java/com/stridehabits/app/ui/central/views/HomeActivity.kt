package com.stridehabits.app.ui.central.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.stridehabits.app.databinding.ActivityHomeBinding
import com.stridehabits.app.ui.central.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "HomeActivity"
    }


// --- Fields


    private lateinit var binds: ActivityHomeBinding
    private val model: HomeViewModel by viewModels()


// --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBindings()
        setupLayoutUi()
    }


// --- UI


    private fun setupBindings() {
        binds = ActivityHomeBinding.inflate(layoutInflater)
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