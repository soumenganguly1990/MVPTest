package com.soumen.mvptest.dashboard.presenter

import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
interface IAllUserPresenter {
    fun retrieveUserListFromRoomDb()
    fun deleteUserFromRoomDb(user: UserEntity)
}