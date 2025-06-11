package com.example.myapps.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapps.repository.AppRepository
import com.example.myapps.utils.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        viewModelScope.launch {

            delay(3000L)
            populateDummyData()
            _isLoading.value = false
        }
    }


    private suspend fun populateDummyData() {
        repository.getUserProfile().asLiveData().observeForever { userProfile ->
            if (userProfile == null) {
                viewModelScope.launch {
                    repository.insertUserProfile(DummyData.getUserProfile())
                    repository.insertAllInterests(DummyData.getInterests())
                    repository.insertAllDailyActivities(DummyData.getDailyActivities())
                    repository.insertAllFriends(DummyData.getFriends())
                    repository.insertAllGalleryItems(DummyData.getGalleryItems())
                    repository.insertAllMusicItems(DummyData.getMusicItems())
                    repository.insertAllVideoItems(DummyData.getVideoItems())
                }
            }
        }
    }
}