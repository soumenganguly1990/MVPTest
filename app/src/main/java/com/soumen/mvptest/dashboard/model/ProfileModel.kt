package com.soumen.mvptest.dashboard.model

import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.roomcommonops.AppDatabase
import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 08-11-2017.
 */
class ProfileModel: IProfileModel {

    override fun updateProfile(user: UserEntity): Int {
        return AppDatabase.getAppDatabase(AppCommonValues.context!!).allUserListDao().updateUser(user)
    }
}