package com.yjooooo.doreandroid.presentation.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.FragmentHelpDoDialogBinding
import com.yjooooo.doreandroid.databinding.FragmentHelpRequestDialogBinding
import com.yjooooo.doreandroid.presentation.help_request.HelpRequestViewModel

class HelpDoDialogFragment : DialogFragment() {
    private var _binding: FragmentHelpDoDialogBinding? = null
    val binding get() = _binding ?: error(getString(R.string.binding_error))

    private val helpRequestViewModel by activityViewModels<HelpRequestViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_help_do_dialog,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()
        initDeleteBtnClickListener()
        initCloseBtnClickListener()
    }

    override fun onStart() {
        super.onStart()
        setLayout()
    }

    private fun setLayout() {
        requireNotNull(dialog).apply {
            requireNotNull(window).apply {
                setLayout(
                    (resources.displayMetrics.widthPixels * 0.91).toInt(),
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                setBackgroundDrawableResource(R.drawable.shape_rect_white)
            }
        }
    }

    private fun initDeleteBtnClickListener() {
        binding.btnHelpRequestCancelDelete.setOnClickListener {
            dismiss()
            helpRequestViewModel.initIsCancelRequest(true)
        }
    }

    private fun initCloseBtnClickListener() {
        binding.btnHelpDoClose.setOnClickListener {
            dismiss()
        }
    }
}
