package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapps.R
import com.example.myapps.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.content.ContextCompat

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup item menu "Tentang" -> "Detail Profil"
        binding.menuItemProfileDetail.tvMenuTitle.text = "Detail Profil"
        binding.menuItemProfileDetail.tvMenuSubtitle.text = "Foto Diri, Deskripsi, Profesi"
        binding.menuItemProfileDetail.ivMenuIcon.setImageResource(R.drawable.ic_account_circle_black_24dp)
        binding.menuItemProfileDetail.ivMenuIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah))
        binding.menuItemProfileDetail.root.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileDetailFragment)
        }

        // Setup item menu "Tentang" -> "Minat"
        binding.menuItemInterests.tvMenuTitle.text = "Minat"
        binding.menuItemInterests.tvMenuSubtitle.text = "Hobi, Suka, Tidak Suka, Cita-cita"
        binding.menuItemInterests.ivMenuIcon.setImageResource(R.drawable.ic_star_black_24dp)
        binding.menuItemInterests.ivMenuIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah))
        binding.menuItemInterests.root.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_interestFragment)
        }

        // Setup item menu "Terhubung" -> "Kontak"
        binding.menuItemContact.tvMenuTitle.text = "Kontak"
        binding.menuItemContact.tvMenuSubtitle.text = "Telepon, Email, Media Sosial"
        binding.menuItemContact.ivMenuIcon.setImageResource(R.drawable.ic_call_black_24dp)
        binding.menuItemContact.ivMenuIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah))
        binding.menuItemContact.root.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_contactFragment)
        }

        // Setup item menu "Terhubung" -> "Temukan Aku"
        binding.menuItemFindMe.tvMenuTitle.text = "Temukan Aku"
        binding.menuItemFindMe.tvMenuSubtitle.text = "Lokasi di Peta"
        binding.menuItemFindMe.ivMenuIcon.setImageResource(R.drawable.ic_location_on_black_24dp)
        binding.menuItemFindMe.ivMenuIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.red_error)) // Contoh warna khusus
        binding.menuItemFindMe.root.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_findMeFragment)
        }

        // Setup item menu "Aplikasi" -> "Tentang Aplikasi"
        binding.menuItemAboutApp.tvMenuTitle.text = "Tentang Aplikasi"
        binding.menuItemAboutApp.tvMenuSubtitle.text = "Informasi Versi Aplikasi"
        binding.menuItemAboutApp.ivMenuIcon.setImageResource(R.drawable.ic_info_black_24dp)
        binding.menuItemAboutApp.ivMenuIcon.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))
        binding.menuItemAboutApp.root.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_aboutDialogFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}