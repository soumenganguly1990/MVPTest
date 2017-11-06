package com.soumen.mvptest.login.presenter

/**
 * Created by IN-LT-51 on 03-11-2017.
 */
interface ILoginPresenter {
    fun resetLoginForm()
    fun loginFromDb(userId: String, password: String)
}