package com.zxy.androiddemo.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingData
import com.zxy.androiddemo.data.DaoRepository
import com.zxy.androiddemo.db.entries.User
import kotlinx.coroutines.flow.Flow

class PagingViewModel @ViewModelInject constructor(val userRepository: DaoRepository) : ViewModel() {

    //    val getUsers: LiveData<PagingData<User>> = userRepository.getAllUsers().asLiveData()
    val getUsers: Flow<PagingData<User>> = userRepository.getAllUsers()

}
