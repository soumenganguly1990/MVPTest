package com.soumen.mvptest.register.presenter

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
interface IRegisterPresentation {
    fun resetRegistratonForm()
    fun doRegister(userId: String, password: String, passwordAgain: String, email: String)
}