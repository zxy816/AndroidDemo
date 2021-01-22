package com.zxy.androiddemo.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingData
import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.data.ApiRepository
import kotlinx.coroutines.flow.Flow

class PagingViewModel @ViewModelInject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    //    val getUsers: LiveData<PagingData<User>> = userRepository.getAllUsers().asLiveData()
    val getUsers: Flow<PagingData<PagingBean>> = apiRepository.getServiceUser()

}
