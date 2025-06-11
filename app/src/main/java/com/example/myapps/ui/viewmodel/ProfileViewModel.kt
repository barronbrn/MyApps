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

    val hobbies: LiveData<List<Interest>> = repository.getInterestsByType("hoby").asLiveData()
    val likes: LiveData<List<Interest>> = repository.getInterestsByType("suka").asLiveData()
    val dislikes: LiveData<List<Interest>> = repository.getInterestsByType("tidak_suka").asLiveData()
    val specialInterests: LiveData<List<Interest>> = repository.getInterestsByType("minat").asLiveData()
    val aspirations: LiveData<List<Interest>> = repository.getInterestsByType("cita_cita").asLiveData()
}