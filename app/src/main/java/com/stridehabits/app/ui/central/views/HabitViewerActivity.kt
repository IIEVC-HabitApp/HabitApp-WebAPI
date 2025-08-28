package com.stridehabits.app.ui.central.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.stridehabits.app.R
import com.stridehabits.app.databinding.ActivityHabitViewerBinding
import com.stridehabits.app.ui.central.viewmodels.HabitViewerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HabitViewerActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "HabitViewerActivity"
    }


// --- Fields


    private lateinit var binds: ActivityHabitViewerBinding
    private val model: HabitViewerViewModel by viewModels()


// --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setupBindings()
        setupLayoutUi()
    }


// --- UI
    
    
    private fun setupBindings() {
        binds = ActivityHabitViewerBinding.inflate(layoutInflater)
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