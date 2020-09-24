package com.wong.mvpdemokotlin.login

import android.text.TextUtils

class LoginActivityPresenter(val view:LoginActivityMVP.View,val model:LoginActivityMVP.Model):LoginActivityMVP.Presenter {

    override fun setView(view: LoginActivityMVP.View) {
        TODO("Not yet implemented")
    }

    override fun loginButtonClick() {
        if(TextUtils.isEmpty(view.getFirstName().trim()) || TextUtils.isEmpty(view.getLastName().trim())){
            view.showInputError()
        }else{
            model.createUser(view.getFirstName(),view.getLastName())
            view.showUerSaveMessage()
        }
    }

    override fun getCurrentUser() {
        if(model.getUser() !=null){
            view.setFirstName(model.getUser()!!.firstName)
            view.setLastName(model.getUser()!!.lastName)
        }
    }
}