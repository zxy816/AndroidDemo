package com.zxy.androiddemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.zxy.androiddemo.db.business.UserRepository
import com.zxy.androiddemo.db.entries.User

class PagingViewModel(val userRepository: UserRepository) : ViewModel() {

    val getUsers: LiveData<PagingData<User>> = userRepository.getAllUsers().asLiveData()

}
