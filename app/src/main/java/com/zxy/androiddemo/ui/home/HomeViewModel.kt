package com.zxy.androiddemo.ui.home

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.zxy.androiddemo.bean.VirHome
import com.zxy.androiddemo.data.ApiRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    val apiRepository: ApiRepository
) : ViewModel() {
    private val _virHome = MutableLiveData<VirHome>()

    fun homeApi(userName: String) = liveData {
        apiRepository.getVirApiHome(userName)
            .onStart {
                //网络请求前(main线程)
                Log.d("vir", "onStart-------${Thread.currentThread().name}")
            }
            .catch {
                Log.d("vir", "catch-------${Thread.currentThread().name}")
            }
            .onCompletion {
                //网络请求完成后(main线程)
                Log.d("vir", "onCompletion-------${Thread.currentThread().name}")
            }
            .collectLatest {
                //(main线程)
                Log.d("vir", Thread.currentThread().name + "------" + it.toString())
                _virHome.postValue(it)
                emit(it)
            }

    }

}