package com.soumen.mvptest.extras

import android.content.Context
import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
class AppCommonValues {

    companion object {

        /* context */
        var context: Context? = null

        /* Login */
        val LOGIN_FORM_EMPTY_FIELDS: Int = 101;
        val LOGIN_FORM_SUCCESS: Int = 102;
        val LOGIN_FORM_FAILURE: Int = 103;

        /* Registration */
        val REG_INVALID_USER_ID: Int = 201
        val REG_INVALID_PASSWORD: Int = 202
        val REG_INVALID_EMAIL: Int = 203
        val REG_PASSWORDS_DIDNT_MATCH = 204
        val REG_FAILED = 205
        val REG_FAILED_CONSTRAINT = 206
        val REG_SUCCESS = 207
        val REG_ALL_FIELDS_REQUIRED = 208

        /* after login is done, save user  entity in this object */
        var userEntity: UserEntity? = null

        /* tab texts */
        var TAB_PROFILE: String = "Profile"
        var TAB_ALL_USERS: String = "All Users"
    }
}