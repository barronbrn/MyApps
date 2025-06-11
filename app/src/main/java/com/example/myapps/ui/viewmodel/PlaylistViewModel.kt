package com.example.myapps.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myapps.data.models.MusicItem
import com.example.myapps.data.models.VideoItem
import com.example.myapps.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    val musicItems: LiveData<List<MusicItem>> = repository.getAllMusicItems().asLiveData()
    val videoItems: LiveData<List<VideoItem>> = repository.getAllVideoItems().asLiveData()
}