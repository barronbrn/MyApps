package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapps.databinding.FragmentFindMeBinding
import com.example.myapps.utils.Constants
import com.example.myapps.utils.openGoogleMapsDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindMeFragment : Fragment() {

    private var _binding: FragmentFindMeBinding? = null
    private val binding get() = _binding!!

    // Koordinat lokasi yang di-hardcode
    private val myLatitude = Constants.YOUR_MAP_LATITUDE
    private val myLongitude = Constants.YOUR_MAP_LONGITUDE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFindMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnGetDirections.setOnClickListener {
            openGoogleMapsDirections(requireContext(), myLatitude, myLongitude)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}