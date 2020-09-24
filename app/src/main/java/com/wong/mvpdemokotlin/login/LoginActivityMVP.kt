package com.wong.mvpdemokotlin.login

import com.wong.mvpdemokotlin.login.data.model.User

interface LoginActivityMVP {
    /**
     * View接口
     */
    interface View{
        fun getFirstName():String
        fun getLastName():String
        fun showInputError():Unit
        fun showUerSaveMessage():Unit
        fun setFirstName(firstName:String):Unit
        fun setLastName(lastName:String):Unit
    }
    /**
     * Presenter接口
     */
    interface Presenter{
        fun setView(view:View):Unit
        fun loginButtonClick():Unit
        fun getCurrentUser():Unit
    }
    /**
     * Model接口
     */
    interface Model{
        fun createUser(firstName:String,lastName:String):Unit
        fun getUser():User?
    }
}