package com.wong.mvpdemokotlin.login.data.model

import com.wong.mvpdemokotlin.login.LoginActivityMVP
import com.wong.mvpdemokotlin.login.data.repo.LoginRepository

class LoginModel(private val repository: LoginRepository):LoginActivityMVP.Model {

    override fun createUser(firstName: String, lastName: String) {
        repository.saveUser(User(firstName,lastName))
    }

    override fun getUser(): User? {
        return repository.getUser()
    }

}