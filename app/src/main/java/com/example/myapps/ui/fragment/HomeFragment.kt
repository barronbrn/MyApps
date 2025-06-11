package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapps.R
import com.example.myapps.databinding.FragmentHomeBinding
import com.example.myapps.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mengamati LiveData dari ViewModel
        viewModel.userProfile.observe(viewLifecycleOwner) { userProfile ->
            userProfile?.let {
                binding.tvWelcomeMessage.text = "Halo, ${it.name}!"
                binding.tvQuoteText.text = it.quote
                binding.tvQuoteAuthor.text = "- ${it.name}"
            }
        }

        viewModel.aboutMeSummary.observe(viewLifecycleOwner) { summary ->
            // Mengatur teks untuk kartu "Tentang Diriku"
            binding.cardAboutMe.tvCardTitle.text = "Tentang Diriku"
            binding.cardAboutMe.tvCardDescription.text = summary
            binding.cardAboutMe.ivIcon.setImageResource(R.drawable.ic_info_black_24dp)
            binding.cardAboutMe.ivIcon.setColorFilter(androidx.core.content.ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah))
        }

        // Setup klik listener untuk kartu-kartu
        binding.cardAboutMe.root.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileDetailFragment)
        }

        binding.cardInterests.tvCardTitle.text = "Minat Terbaruku"
        binding.cardInterests.tvCardDescription.text = "Mengulik dunia teknologi & seni digital."
        binding.cardInterests.ivIcon.setImageResource(R.drawable.ic_star_black_24dp)
        binding.cardInterests.ivIcon.setColorFilter(androidx.core.content.ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah))
        binding.cardInterests.root.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_interestFragment)
        }

        binding.cardDailyActivity.tvCardTitle.text = "Aktivitas Terbaru"
        binding.cardDailyActivity.tvCardDescription.text = "Minggu ini fokus belajar programming."
        binding.cardDailyActivity.ivIcon.setImageResource(R.drawable.ic_list_black_24dp)
        binding.cardDailyActivity.ivIcon.setColorFilter(androidx.core.content.ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah))
        binding.cardDailyActivity.root.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_dailyActivityFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}