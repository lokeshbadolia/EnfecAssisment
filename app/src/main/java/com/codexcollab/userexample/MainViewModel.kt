package com.codexcollab.userexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codexcollab.userexample.RetrofitInstance.apiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _data = MutableLiveData<ArrayList<User>>()
    val data: LiveData<ArrayList<User>> = _data

    fun fetchData() {
        viewModelScope.launch {
            try {
                val response = apiService.getUsers()
                if (response.isSuccessful) {
                    _data.value = response.body()
                } else {
                    _data.value = arrayListOf()
                }
            } catch (e: Exception) {
                _data.value = arrayListOf()
            }
        }
    }
}