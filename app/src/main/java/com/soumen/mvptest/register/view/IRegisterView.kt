package com.soumen.mvptest.register.view

import com.soumen.mvptest.register.entity.RegistrationResultModel

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
interface IRegisterView {
    fun clearRegistrationForm()
    fun onRegistrationCompleted(registrationResultModel: RegistrationResultModel)
}