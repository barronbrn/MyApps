package com.example.myapps.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapps.R
import com.example.myapps.databinding.FragmentInterestBinding
import com.example.myapps.ui.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.card.MaterialCardView



@AndroidEntryPoint
class InterestFragment : Fragment() {

    private var _binding: FragmentInterestBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInterestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mengamati LiveData untuk setiap kategori minat dan mengisi chips
        viewModel.hobbies.observe(viewLifecycleOwner) { hobbies ->
            addChipsToLayout(binding.llHobbiesChips, hobbies.map { it.item }, R.color.biru_muda_cerah)
        }
        viewModel.likes.observe(viewLifecycleOwner) { likes ->
            addChipsToLayout(binding.llLikesChips, likes.map { it.item }, R.color.biru_muda_cerah)
        }
        viewModel.dislikes.observe(viewLifecycleOwner) { dislikes ->
            addChipsToLayout(binding.llDislikesChips, dislikes.map { it.item }, R.color.red_error)
        }
        viewModel.specialInterests.observe(viewLifecycleOwner) { specialInterests ->
            addChipsToLayout(binding.llSpecialInterestsChips, specialInterests.map { it.item }, R.color.biru_muda_cerah)
        }
        viewModel.aspirations.observe(viewLifecycleOwner) { aspirations ->
            addChipsToLayout(binding.llAspirationsChips, aspirations.map { it.item }, R.color.biru_muda_cerah)
        }
    }

    private fun addChipsToLayout(layout: FlexboxLayout, items: List<String>, colorResId: Int) {
        layout.removeAllViews() // Hapus chip yang sudah ada

        if (items.isEmpty()) {
            val noDataText = TextView(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                text = "Tidak ada data."
                setTextColor(ContextCompat.getColor(requireContext(), R.color.abu_abu_gelap))
                textSize = 14f
            }
            layout.addView(noDataText)
            return
        }

        val chipColor = ContextCompat.getColor(requireContext(), colorResId)
        val chipBgColor = ContextCompat.getColor(requireContext(), R.color.biru_muda_cerah_transparent) // Menggunakan warna transparan
        val strokeColor = ContextCompat.getColor(requireContext(), colorResId)

        for (item in items) {
            val chipView = LayoutInflater.from(context).inflate(R.layout.item_interest_chip, layout, false) as MaterialCardView
            val textView = chipView.findViewById<TextView>(R.id.tv_chip_text)
            textView.text = item
            textView.setTextColor(chipColor) // Mengatur warna teks chip

            // Mengatur warna latar belakang dan stroke secara programatis
            chipView.setCardBackgroundColor(chipBgColor)
            chipView.strokeColor = strokeColor

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 8, 8) // Margin antar chip
            chipView.layoutParams = params
            layout.addView(chipView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}