package com.example.myapps.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myapps.data.models.GalleryItem
import com.example.myapps.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    val galleryItems: LiveData<List<GalleryItem>> = repository.getAllGalleryItems().asLiveData()
}