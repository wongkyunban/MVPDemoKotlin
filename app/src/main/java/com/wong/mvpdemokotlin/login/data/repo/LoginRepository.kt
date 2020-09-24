package com.wong.mvpdemokotlin.login.data.repo

import com.wong.mvpdemokotlin.login.data.model.User

interface LoginRepository {
    fun getUser():User?
    fun saveUser(user:User):Unit
}