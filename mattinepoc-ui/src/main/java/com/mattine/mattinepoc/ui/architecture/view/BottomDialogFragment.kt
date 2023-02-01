package com.mattine.mattinepoc.ui.architecture.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mattine.poc.ui.R

class BottomDialogFragment(
    private val attachedFragment: Fragment
) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_bottom_sheet_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val container = view.findViewById<FrameLayout>(R.id.design_bottom_sheet)
        childFragmentManager.beginTransaction().apply {
            add(container.id, attachedFragment, attachedFragment.tag)
        }.commit()
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog

        if (dialog != null) {
            val bottomSheet: View = dialog.findViewById(R.id.design_bottom_sheet)
            bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }
}