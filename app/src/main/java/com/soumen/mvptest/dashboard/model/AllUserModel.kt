package com.soumen.mvptest.dashboard.model

import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.roomcommonops.AppDatabase
import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
class AllUserModel: IAllUserModel {

    override fun retrieveFullListOfUsersFromDb(): ArrayList<UserEntity> {
        try {
            var allUserList: ArrayList<UserEntity>
            allUserList = ArrayList(AppDatabase.getAppDatabase(AppCommonValues.context)
                    .allUserListDao().getListOfAllUsers())
            if(allUserList!! == null || allUserList!!.size == 0) {
                return null!!
            } else {
                return allUserList
            }
        } catch (e: Exception) {
            return null!!
        }
    }

    override fun deleteTheUserSelectedByUserFromDb(user: UserEntity): Int {
        return AppDatabase.getAppDatabase(AppCommonValues.context).allUserListDao().deleteAnUser(user)
    }
}