package com.yjooooo.doreandroid.presentation.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.FragmentHelpDoDialogBinding
import timber.log.Timber

class HelpDoDialogFragment : DialogFragment() {
    private var _binding: FragmentHelpDoDialogBinding? = null
    val binding get() = _binding ?: error(getString(R.string.binding_error))

    private val helpViewModel by activityViewModels<HelpViewModel>()

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
        binding.help = helpViewModel.oneHelp.value
        Timber.tag("Help_dialog").d(binding.help.toString())
        setLayout()
        initHelpDoConfirmClickListener()
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

    private fun initHelpDoConfirmClickListener() {
        binding.btnHelpDoConfirm.setOnClickListener {
            helpViewModel.postHelpDo(requireNotNull(arguments).getInt("helpId"))
            dismiss()
        }
    }

    private fun initCloseBtnClickListener() {
        binding.btnHelpDoClose.setOnClickListener {
            dismiss()
        }
    }
}
