package com.soumen.mvptest.dashboard.model

import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
interface IAllUserModel {
    fun retrieveFullListOfUsersFromDb(): ArrayList<UserEntity>
    fun deleteTheUserSelectedByUserFromDb(user: UserEntity): Int
}