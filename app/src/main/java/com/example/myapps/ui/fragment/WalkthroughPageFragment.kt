package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapps.databinding.FragmentWalkthroughPageBinding

class WalkthroughPageFragment : Fragment() {

    private var _binding: FragmentWalkthroughPageBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_IMAGE_RES_ID = "image_res_id"
        private const val ARG_TITLE = "title"
        private const val ARG_DESCRIPTION = "description"

        fun newInstance(imageResId: Int, title: String, description: String): WalkthroughPageFragment {
            val fragment = WalkthroughPageFragment()
            val args = Bundle().apply {
                putInt(ARG_IMAGE_RES_ID, imageResId)
                putString(ARG_TITLE, title)
                putString(ARG_DESCRIPTION, description)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalkthroughPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            binding.ivWalkthroughImage.setImageResource(it.getInt(ARG_IMAGE_RES_ID))
            binding.tvWalkthroughTitle.text = it.getString(ARG_TITLE)
            binding.tvWalkthroughDescription.text = it.getString(ARG_DESCRIPTION)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
