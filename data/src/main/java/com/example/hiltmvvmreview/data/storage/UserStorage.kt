package com.example.hiltmvvmreview.data.storage

import com.example.hiltmvvmreview.data.storage.models.User


interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}