package com.example.hiltmvvmreview.domain.usecase

import com.example.hiltmvvmreview.domain.repository.UserRepository
import com.example.hiltmvvmreview.domain.models.SaveUserName


class SaveUserNameUseCase(private val userRepository: UserRepository){

     fun execute(param: SaveUserName) : Boolean{
        val oldUserName = userRepository.getName()
        if(oldUserName.firstName == param.name){
            return true
        }

       val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}

