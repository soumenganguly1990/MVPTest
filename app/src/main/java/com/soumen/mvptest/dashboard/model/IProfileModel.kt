package com.soumen.mvptest.dashboard.model

import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 08-11-2017.
 */
interface IProfileModel {
    fun updateProfile(user: UserEntity): Int
}