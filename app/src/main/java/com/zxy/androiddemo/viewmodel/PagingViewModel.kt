package com.zxy.androiddemo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.zxy.androiddemo.db.business.UserRepository
import com.zxy.androiddemo.db.entries.User
import kotlinx.coroutines.flow.Flow

class PagingViewModel @ViewModelInject constructor(val userRepository: UserRepository) : ViewModel() {

    //    val getUsers: LiveData<PagingData<User>> = userRepository.getAllUsers().asLiveData()
    val getUsers: Flow<PagingData<User>> = userRepository.getAllUsers()

}
