package com.example.devhub.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devhub.Api.ApiService
import com.example.devhub.model.User
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
     private var userResponse_: MutableLiveData<User> = MutableLiveData()
     val userResponse : LiveData<User> = userResponse_
      var errorMessage : MutableLiveData<String> = MutableLiveData()

    fun getUser(name:String){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val user = apiService?.getUser(name)
                if (user != null) {
                    userResponse_.value = user
                }
            }catch (e:Exception){
                errorMessage.value = e.message.toString()
            }
        }
    }
}