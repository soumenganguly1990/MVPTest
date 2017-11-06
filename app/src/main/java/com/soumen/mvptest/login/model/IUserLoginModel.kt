package com.soumen.mvptest.login.model

import com.soumen.mvptest.login.entity.LoginStatus

/**
 * Created by IN-LT-51 on 03-11-2017.
 */
interface IUserLoginModel {
    fun tryLoginFromDbWithUserData(userId: String, password: String): LoginStatus
}