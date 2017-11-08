package com.soumen.mvptest.dashboard.view

import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
interface IDashboardView {
    fun onAllUserListRetrieved(userList: ArrayList<UserEntity>?)
    fun onSelectedUserDeleted(status: Int)
}