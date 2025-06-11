package com.example.myapps.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myapps.data.models.Interest
import com.example.myapps.data.models.UserProfile
import com.example.myapps.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {


    val userProfile: LiveData<UserProfile?> = repository.getUserProfile().asLiveData()


    val hobbies: LiveData<List<Interest>> = repository.getInterestsByType("Hobi").asLiveData()
    val likes: LiveData<List<Interest>> = repository.getInterestsByType("Suka").asLiveData()
    val dislikes: LiveData<List<Interest>> = repository.getInterestsByType("Tidak Suka").asLiveData()
    val specialInterests: LiveData<List<Interest>> = repository.getInterestsByType("Minat Khusus").asLiveData()
    val aspirations: LiveData<List<Interest>> = repository.getInterestsByType("Cita-cita").asLiveData()
}