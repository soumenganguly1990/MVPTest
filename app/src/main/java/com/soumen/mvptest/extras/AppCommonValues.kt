package com.soumen.mvptest.extras

import android.content.Context

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
    }
}