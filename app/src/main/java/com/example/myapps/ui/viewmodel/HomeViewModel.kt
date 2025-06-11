package com.example.myapps.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import com.example.myapps.data.models.UserProfile
import com.example.myapps.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    // Mengambil profil pengguna dari repository dan mengkonversinya menjadi LiveData
    val userProfile: LiveData<UserProfile?> = repository.getUserProfile().asLiveData()

    // Membuat ringkasan deskripsi dari profil pengguna menggunakan LiveData transformation
    val aboutMeSummary: LiveData<String> = userProfile.map { profile ->
        profile?.let {
            val descriptionWords = it.description.split(" ")
            if (descriptionWords.size > 15) {
                descriptionWords.take(15).joinToString(" ") + "..."
            } else {
                it.description
            }
        } ?: "Memuat deskripsi..."
    }
}