package com.example.myapps.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapps.utils.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WalkthroughViewModel @Inject constructor() : ViewModel() {

    val walkthroughPages = DummyData.getWalkthroughPages()
}