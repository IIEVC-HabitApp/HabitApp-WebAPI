package com.stridehabits.app.ui.central.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.stridehabits.app.databinding.FragmentHomeHabitsBinding
import com.stridehabits.app.ui.central.viewmodels.HomeHabitsViewModel
import com.stridehabits.app.ui.central.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeHabitsFragment : Fragment() {
    companion object {
        private const val TAG = "HomeHabitsFragment"
    }
    
    
// --- Fields
    
    
    private lateinit var binds: FragmentHomeHabitsBinding
    private val sharedModel: HomeViewModel by activityViewModels()
    private val activeModel: HomeHabitsViewModel by viewModels()
    
    
// --- Lifecycle
    
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = createBindings(inflater, container)
    
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Setup initial startup logic
    }
    
    
// --- UI
    
    
    private fun createBindings(
        inflater: LayoutInflater, container: ViewGroup?
    ): View {
        binds = FragmentHomeHabitsBinding.inflate(inflater, container, false)
        return binds.root
    }
}