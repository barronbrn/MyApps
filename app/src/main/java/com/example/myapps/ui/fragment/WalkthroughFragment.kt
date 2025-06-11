package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import androidx.navigation.fragment.findNavController
import com.example.myapps.R
import com.example.myapps.databinding.FragmentWalkthroughBinding
import com.example.myapps.ui.adapter.WalkthroughPagerAdapter
import com.example.myapps.ui.viewmodel.WalkthroughViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalkthroughFragment : Fragment() {

    private var _binding: FragmentWalkthroughBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WalkthroughViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalkthroughBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = WalkthroughPagerAdapter(this, viewModel.walkthroughPages)
        binding.viewPagerWalkthrough.adapter = pagerAdapter

        TabLayoutMediator(binding.pageIndicator, binding.viewPagerWalkthrough) { tab, position ->
        }.attach()


        binding.viewPagerWalkthrough.registerOnPageChangeCallback(object : androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == viewModel.walkthroughPages.size - 1) {
                    binding.btnNextGetStarted.text = "Mulai"
                } else {
                    binding.btnNextGetStarted.text = "Selanjutnya"
                }
            }
        })

        binding.btnSkip.setOnClickListener {
            findNavController().navigate(R.id.action_walkthroughFragment_to_homeFragment)
        }


        binding.btnNextGetStarted.setOnClickListener {
            if (binding.viewPagerWalkthrough.currentItem == viewModel.walkthroughPages.size - 1) {

                findNavController().navigate(R.id.action_walkthroughFragment_to_homeFragment)
            } else {

                binding.viewPagerWalkthrough.currentItem = binding.viewPagerWalkthrough.currentItem + 1
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
