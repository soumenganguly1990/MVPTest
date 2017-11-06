package com.soumen.mvptest.register.presenter

import com.soumen.mvptest.register.model.RegistrationModel
import com.soumen.mvptest.register.view.IRegisterView

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
class RegisterPresentationImpl: IRegisterPresentation {

    var iRegisterView: IRegisterView
    lateinit var registrationModel: RegistrationModel

    constructor(iRegisterView: IRegisterView) {
        this.iRegisterView = iRegisterView
    }

    override fun resetRegistratonForm() {
        iRegisterView.clearRegistrationForm()
    }

    override fun doRegister(userId: String, password: String, passwordAgain: String, email: String) {
        registrationModel = RegistrationModel(userId, password, passwordAgain, email)
        iRegisterView.onRegistrationCompleted(registrationModel.registerTheUser())
    }
}