package com.soumen.mvptest.register.presenter

import com.soumen.mvptest.register.model.IUserRegistrationModel
import com.soumen.mvptest.register.model.RegistrationModel
import com.soumen.mvptest.register.view.IRegisterView

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
class RegisterPresentationImpl: IRegisterPresentation {

    var iRegisterView: IRegisterView
    lateinit var iUserregistrationModel: IUserRegistrationModel

    constructor(iRegisterView: IRegisterView) {
        this.iRegisterView = iRegisterView
    }

    override fun resetRegistratonForm() {
        iRegisterView.clearRegistrationForm()
    }

    override fun doRegister(userId: String, password: String, passwordAgain: String, email: String, phone: Long) {
        iUserregistrationModel = RegistrationModel(userId, password, passwordAgain, email, phone)
        iRegisterView.onRegistrationCompleted(iUserregistrationModel.registerTheUser())
    }
}