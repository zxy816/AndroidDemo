package com.zxy.androiddemo.ui.paging

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.data.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(apiRepository: ApiRepository) : ViewModel() {

    val getHubAndroid: Flow<PagingData<PagingBean>> = apiRepository.getHubAndroid()

}
