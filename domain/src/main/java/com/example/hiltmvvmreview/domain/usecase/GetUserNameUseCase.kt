package com.example.hiltmvvmreview.domain.usecase

import com.example.hiltmvvmreview.domain.repository.UserRepository
import com.example.hiltmvvmreview.models.UserName

class GetUserNameUseCase(private  val userRepository: UserRepository) {

    fun execute(): UserName {
        return  userRepository.getName()
    }

}





