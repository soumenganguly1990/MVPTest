package com.soumen.mvptest.dashboard.presenter

import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 08-11-2017.
 */
interface IProfilePresenter {
    fun updateUserInDb(user: UserEntity)
}