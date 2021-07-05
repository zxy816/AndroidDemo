package com.zxy.androiddemo.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.zxy.androiddemo.data.ApiRepository

class HomeViewModel @ViewModelInject constructor(val apiRepository: ApiRepository) : ViewModel() {
    fun homeApi(userName: String) = apiRepository.getVirApiHome(userName)
}