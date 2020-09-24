package com.wong.mvpdemokotlin.login.data.repo

import com.wong.mvpdemokotlin.login.data.model.User

class UserRepository:LoginRepository {
    private var user:User? = null
    override fun getUser(): User? {
        if(user == null){
            user = User("King","Wong")
            return user
        }
        return user
    }

    override fun saveUser(user: User) {
        this.user = user
    }
}