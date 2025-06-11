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

        // Setup Opsi Kontak: Twitter
        binding.contactOptionFacebook.ivContactIcon.setImageResource(R.drawable.twitter)
        binding.contactOptionFacebook.tvContactTitle.text = "Twitter"
        binding.contactOptionFacebook.tvContactSubtitle.text = "barron_brn"
        binding.contactOptionFacebook.root.setOnClickListener {
            openSocialMedia(requireContext(), Constants.YOUR_TWITTER_URL)
        }

        // Setup Opsi Kontak: WhatsApp
        binding.contactOptionWhatsapp.ivContactIcon.setImageResource(R.drawable.whatsapp)
        binding.contactOptionWhatsapp.tvContactTitle.text = "WhatsApp"
        binding.contactOptionWhatsapp.tvContactSubtitle.text = Constants.YOUR_PHONE_NUMBER
        binding.contactOptionWhatsapp.root.setOnClickListener {
            openUrl(requireContext(), Constants.YOUR_WHATSAPP_URL)
        }

        // setup Opsi Kontak: Instagram
        binding.contactOptionInstagram.ivContactIcon.setImageResource(R.drawable.instagram)
        binding.contactOptionInstagram.tvContactTitle.text = "Instagram"
        binding.contactOptionInstagram.tvContactSubtitle.text = "barron.brn"
        binding.contactOptionInstagram.root.setOnClickListener {
            openSocialMedia(requireContext(), Constants.YOUR_INSTAGRAM_URL)
        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}