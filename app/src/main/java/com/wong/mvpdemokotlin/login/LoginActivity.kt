package com.wong.mvpdemokotlin.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.wong.mvpdemokotlin.R
import com.wong.mvpdemokotlin.login.data.model.LoginModel
import com.wong.mvpdemokotlin.login.data.repo.LoginRepository
import com.wong.mvpdemokotlin.login.data.repo.UserRepository

class LoginActivity : AppCompatActivity(),LoginActivityMVP.View {

    private var presenter:LoginActivityMVP.Presenter? = null
    private var mETFirstName:EditText? = null
    private var mETLastName:EditText? = null
    private var mBtnLogin: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mETFirstName = findViewById(R.id.loginActivity_firstName_editText)
        mETLastName = findViewById(R.id.loginActivity_lastName_editText)
        mBtnLogin = findViewById(R.id.loginActivity_login_button)
        presenter = LoginActivityPresenter(this,LoginModel(UserRepository()))
        mBtnLogin!!.setOnClickListener(View.OnClickListener { presenter!!.loginButtonClick() })
    }

    override fun onResume() {
        super.onResume()
        presenter!!.getCurrentUser()
    }

    override fun getFirstName(): String {
        return mETFirstName!!.text.toString()
    }

    override fun getLastName(): String {
        return mETLastName!!.text.toString()
    }

    override fun showInputError() {
        Toast.makeText(this,"First Name or Last Name cannot be empty",Toast.LENGTH_LONG).show()
    }

    override fun showUerSaveMessage() {
        Toast.makeText(this,"User saved successfully",Toast.LENGTH_LONG).show()
    }

    override fun setFirstName(firstName: String) {
        mETFirstName!!.setText(firstName)
    }

    override fun setLastName(lastName: String) {
        mETLastName!!.setText(lastName)
    }
}