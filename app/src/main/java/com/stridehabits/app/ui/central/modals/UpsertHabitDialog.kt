package com.stridehabits.app.ui.central.modals

import androidx.fragment.app.DialogFragment
import com.stridehabits.app.databinding.ModalDialogUpsertHabitBinding

class UpsertHabitDialog : DialogFragment() {
    companion object {
        private const val TAG = "UpsertHabitDialog"

        /**
         * Factory for [UpsertHabitDialog].
         */
        fun newInstance() = UpsertHabitDialog()
    }
    
    
// --- Fields
    
    
    private var _binding: ModalDialogUpsertHabitBinding? = null
    private val binding get() = _binding!!
}