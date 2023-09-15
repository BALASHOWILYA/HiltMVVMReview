package com.example.hiltmvvmreview.data.repository


import com.example.hiltmvvmreview.data.storage.models.User
import com.example.hiltmvvmreview.data.storage.UserStorage
import com.example.hiltmvvmreview.domain.repository.UserRepository
import com.example.hiltmvvmreview.domain.models.SaveUserName
import com.example.hiltmvvmreview.models.UserName




class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository{




    override fun saveName(saveParam: SaveUserName): Boolean{
        val user = User(firstName = saveParam.name, lastName = "")
        return userStorage.save(user)
    }




    override fun getName(): UserName {
        val user = userStorage.get()
        return UserName(firstName = user.firstName, lastName = user.lastName)
        /*
        var firstName = sharedPreferences.getString(KEY_FIRST_NAME, "")
        if(firstName == null){
        firstName = DEFAULT_NAME
        }
         */

    }
}