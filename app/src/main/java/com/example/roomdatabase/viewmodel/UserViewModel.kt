package com.example.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.UserDatabase
import com.example.roomdatabase.repository.UserRepository
import com.example.roomdatabase.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//A VIEW MODEL PROVIDE COMMUNICATION BETWEEN UI AND REPOSITORY AND PROVIDE DATA TO UI
class UserViewModel(application: Application) : AndroidViewModel(application){

     val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao= UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData= repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)
        }
    }
}