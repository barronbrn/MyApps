package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.myapps.R
import com.example.myapps.databinding.FragmentAboutDialogBinding
import com.example.myapps.utils.Constants



class AboutDialogFragment : DialogFragment() {

    private var _binding : FragmentAboutDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.appIcon.setImageResource(R.drawable.ic_launcher_foreground)
        binding.appName.text = getString(R.string.app_name)
        binding.appVersion.text = "Versi: ${Constants.APP_VERSION}"
        binding.appBuild.text = "Build: ${Constants.APP_BUILD}"
        binding.appDeveloper.text = "Dikembangkan oleh: [Dani Herawan]"
        binding.appCopyright.text = "© 2025. All rights reserved."

        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}