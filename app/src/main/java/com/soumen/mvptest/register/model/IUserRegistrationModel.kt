package com.soumen.mvptest.register.model

import com.soumen.mvptest.register.entity.RegistrationResultModel

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
interface IUserRegistrationModel {
    fun registerTheUser(): RegistrationResultModel
}