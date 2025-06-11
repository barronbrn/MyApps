package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapps.R
import com.example.myapps.databinding.FragmentContactBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.content.ContextCompat
import com.example.myapps.utils.Constants
import com.example.myapps.utils.makePhoneCall
import com.example.myapps.utils.openEmail
import com.example.myapps.utils.openSocialMedia
import com.example.myapps.utils.openUrl

@AndroidEntryPoint
class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Opsi Kontak: Telepon
        binding.contactOptionPhone.ivContactIcon.setImageResource(R.drawable.ic_call_black_24dp)
        binding.contactOptionPhone.ivContactIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah))
        binding.contactOptionPhone.tvContactTitle.text = "Telepon"
        binding.contactOptionPhone.tvContactSubtitle.text = Constants.YOUR_PHONE_NUMBER
        binding.contactOptionPhone.root.setOnClickListener {
            makePhoneCall(requireContext(), Constants.YOUR_PHONE_NUMBER)
        }

        // Setup Opsi Kontak: Email
        binding.contactOptionEmail.ivContactIcon.setImageResource(R.drawable.ic_email_black_24dp)
        binding.contactOptionEmail.ivContactIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah))
        binding.contactOptionEmail.tvContactTitle.text = "Email"
        binding.contactOptionEmail.tvContactSubtitle.text = Constants.YOUR_EMAIL
        binding.contactOptionEmail.root.setOnClickListener {
            openEmail(requireContext(), Constants.YOUR_EMAIL, "Halo dari Aplikasi Persona")
        }

        // Setup Opsi Kontak: Facebook
        binding.contactOptionFacebook.ivContactIcon.setImageResource(R.drawable.ic_facebook_black_24dp)
        binding.contactOptionFacebook.ivContactIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah)) // Atau warna khusus Facebook
        binding.contactOptionFacebook.tvContactTitle.text = "Facebook"
        binding.contactOptionFacebook.tvContactSubtitle.text = "facebook.com/your_profile"
        binding.contactOptionFacebook.root.setOnClickListener {
            openSocialMedia(requireContext(), Constants.YOUR_TWITTER_URL)
        }

        // Setup Opsi Kontak: WhatsApp
        binding.contactOptionWhatsapp.ivContactIcon.setImageResource(R.drawable.ic_whatsapp_black_24dp)
        binding.contactOptionWhatsapp.ivContactIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah)) // Atau warna khusus WhatsApp
        binding.contactOptionWhatsapp.tvContactTitle.text = "WhatsApp"
        binding.contactOptionWhatsapp.tvContactSubtitle.text = Constants.YOUR_PHONE_NUMBER
        binding.contactOptionWhatsapp.root.setOnClickListener {
            openUrl(requireContext(), Constants.YOUR_WHATSAPP_URL)
        }

        // Setup Opsi Kontak: Temukan Aku (Navigasi ke FindMeFragment)
        binding.contactOptionFindMe.ivContactIcon.setImageResource(R.drawable.ic_location_on_black_24dp)
        binding.contactOptionFindMe.ivContactIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.red_error))
        binding.contactOptionFindMe.tvContactTitle.text = "Temukan Aku"
        binding.contactOptionFindMe.tvContactSubtitle.text = "Lihat lokasiku di peta"
        binding.contactOptionFindMe.root.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_findMeFragment)
        }

        // Setup Opsi Kontak: Tentang Aplikasi (Navigasi ke AboutDialogFragment)
        binding.contactOptionAboutApp.ivContactIcon.setImageResource(R.drawable.ic_info_black_24dp)
        binding.contactOptionAboutApp.ivContactIcon.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))
        binding.contactOptionAboutApp.tvContactTitle.text = "Tentang Aplikasi"
        binding.contactOptionAboutApp.tvContactSubtitle.text = "Versi dan informasi aplikasi"
        binding.contactOptionAboutApp.root.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_aboutDialogFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}