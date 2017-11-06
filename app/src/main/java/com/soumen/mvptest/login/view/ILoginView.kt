package com.soumen.mvptest.login.view

import com.soumen.mvptest.login.entity.LoginStatus

/**
 * Created by IN-LT-51 on 03-11-2017.
 */
interface ILoginView {
    fun onResetLoginFields()
    fun onLoginResultRetrieved(loginStatus: LoginStatus)
}