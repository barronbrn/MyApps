package com.example.myapps.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myapps.data.models.DailyActivity
import com.example.myapps.data.models.Friend
import com.example.myapps.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DailyActivityViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    // Mengambil daftar aktivitas harian
    val dailyActivities: LiveData<List<DailyActivity>> = repository.getAllDailyActivities().asLiveData()

    // Mengambil daftar teman
    val friends: LiveData<List<Friend>> = repository.getAllFriends().asLiveData()

}