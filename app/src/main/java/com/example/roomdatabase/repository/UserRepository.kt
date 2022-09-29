package com.example.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase.data.UserDao
import com.example.roomdatabase.model.User


//A REPOSITORY ABSTRACT ACCESS TO MULTIPLE DATA SOURCES
class UserRepository(private val userDao: UserDao){

    val readAllData: LiveData<List<User>> =userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun delete(user: User)
    {
        userDao.delete(user)
    }

    suspend fun deleteAllUser(){
        userDao.deleteAllUser()
    }

}