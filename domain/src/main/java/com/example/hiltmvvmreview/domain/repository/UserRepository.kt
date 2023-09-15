package com.example.hiltmvvmreview.domain.repository

import com.example.hiltmvvmreview.domain.models.SaveUserName
import com.example.hiltmvvmreview.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserName): Boolean

    fun getName(): UserName

}
