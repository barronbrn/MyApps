package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapps.databinding.FragmentDailyActivityBinding
import com.example.myapps.ui.adapter.DailyActivityAdapter
import com.example.myapps.ui.adapter.FriendAdapter


import com.example.myapps.ui.viewmodel.DailyActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DailyActivityFragment : Fragment() {

    private var _binding: FragmentDailyActivityBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DailyActivityViewModel by viewModels()

    private lateinit var dailyActivityAdapter: DailyActivityAdapter
    private lateinit var friendAdapter: FriendAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDailyActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        observeViewModels()
    }

    private fun setupRecyclerViews() {
        // Daily Activity
        dailyActivityAdapter = DailyActivityAdapter()
        binding.rvDailyActivities.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dailyActivityAdapter
        }

        // Friends List (Horizontal)
        friendAdapter = FriendAdapter()
        binding.rvFriends.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = friendAdapter
        }

    }

    private fun observeViewModels() {
        viewModel.dailyActivities.observe(viewLifecycleOwner) { activities ->
            dailyActivityAdapter.submitList(activities)
        }
        viewModel.friends.observe(viewLifecycleOwner) { friends ->
            friendAdapter.submitList(friends)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}