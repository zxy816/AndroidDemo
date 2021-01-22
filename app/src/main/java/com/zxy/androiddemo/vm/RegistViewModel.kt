package com.zxy.androiddemo.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zxy.androiddemo.data.ApiRepository
import com.zxy.androiddemo.data.DaoRepository
import com.zxy.androiddemo.db.entries.Address
import com.zxy.androiddemo.db.entries.User
import com.zxy.androiddemo.http.ApiLoader
import com.zxy.androiddemo.http.ApiResult
import com.zxy.androiddemo.http.ApiService
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync

class RegistViewModel @ViewModelInject constructor(
        private val userRepository: DaoRepository, private val apiService: ApiService) : ViewModel() {

    private val translateResult: MutableLiveData<String> = MutableLiveData()

    val translate: LiveData<String> get() = translateResult

    fun registerUserDB() {
        doAsync {
            for (i in 0..100) {
                val user = User()
                user.userName = "zxy$i"
                user.pwd = "123456"
                user.sex = if (i % 2 == 0) "男" else "女"
                user.age = i
                user.phone = "18792430923"
                val address = Address()
                address.province = "陕西省"
                address.city = "西安市"
                address.county = "雁塔区"
                userRepository.insertUser(user)
            }
        }
    }

    fun translateWord(word: String) {
        viewModelScope.launch {
            when (val result = apiService.translate(word)) {
                is ApiResult.Success -> {
                    translateResult.value = result.data.translateResult[0][0].tgt
                }
                is ApiResult.Failure -> {
                    translateResult.value = "errorCode:${result.errorCode},errorMsg:${result.errorMsg}"
                }
            }
        }
    }

    fun lotteryBet() {
        viewModelScope.launch {
            when (val result = apiService.lotteryBet(ApiLoader.lotteryBet())) {
                is ApiResult.Success -> {
                    translateResult.value = result.data.toString()
                }
                is ApiResult.Failure -> {
                    translateResult.value = "errorCode:${result.errorCode},errorMsg:${result.errorMsg}"
                }
            }
        }
    }
}
