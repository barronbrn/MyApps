package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapps.R
import com.example.myapps.databinding.FragmentProfileDetailBinding
import com.example.myapps.ui.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import coil.load

@AndroidEntryPoint
class ProfileDetailFragment : Fragment() {

    private var _binding: FragmentProfileDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userProfile.observe(viewLifecycleOwner) { userProfile ->
            userProfile?.let {
                binding.tvProfileName.text = it.name
                binding.tvProfileProfession.text = it.profession
                binding.tvProfileDescription.text = it.description
                binding.tvProfileQuote.text = "“${it.quote}”"

                val context = binding.root.context
                val drawableId = context.resources.getIdentifier(
                    it.photoUrl,
                    "drawable",
                    context.packageName
                )
                binding.ivProfilePhoto.load(drawableId) {
                    placeholder(R.drawable.ic_profile_placeholder)
                    error(R.drawable.ic_profile_placeholder)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}