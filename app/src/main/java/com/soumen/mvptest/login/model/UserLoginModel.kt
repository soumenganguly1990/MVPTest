package com.soumen.mvptest.login.model

import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.login.entity.LoginStatus
import com.soumen.mvptest.register.entity.UserEntity
import com.soumen.mvptest.roomcommonops.AppDatabase

/**
 * Created by IN-LT-51 on 03-11-2017.
 */
class UserLoginModel(): IUserLoginModel {

    override fun tryLoginFromDbWithUserData(userId: String, password: String): LoginStatus {
        if(userId.equals("") || password.equals("")) {
            return LoginStatus(false, AppCommonValues.LOGIN_FORM_EMPTY_FIELDS)
        } else {
            var userEntity: UserEntity = AppDatabase.getAppDatabase(AppCommonValues.context!!).loginDao()
                    .validateUserLogin(userId, password)
            if(userEntity != null) {
                return LoginStatus(true, AppCommonValues.LOGIN_FORM_SUCCESS)
            } else {
                return LoginStatus(false, AppCommonValues.LOGIN_FORM_FAILURE)
            }
        }
    }
}