package com.example.myapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapps.databinding.FragmentPlaylistBinding
import com.example.myapps.ui.adapter.MusicAdapter
import com.example.myapps.ui.adapter.VideoAdapter
import com.example.myapps.ui.viewmodel.PlaylistViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaylistFragment : Fragment() {

    private var _binding: FragmentPlaylistBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PlaylistViewModel by viewModels() // Gunakan ViewModel yang sama
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        musicAdapter = MusicAdapter()
        binding.rvMusic.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = musicAdapter
        }

        videoAdapter = VideoAdapter { videoUrl ->
            // Trigger Intent untuk membuka video eksternal
            val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(videoUrl))
            startActivity(intent)
        }
        binding.rvVideo.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = videoAdapter
        }

        viewModel.musicItems.observe(viewLifecycleOwner) { musicItems ->
            musicAdapter.submitList(musicItems)
        }
        viewModel.videoItems.observe(viewLifecycleOwner) { videoItems ->
            videoAdapter.submitList(videoItems)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}