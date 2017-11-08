package com.soumen.mvptest.register.presenter

import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.register.model.IUserRegistrationModel
import com.soumen.mvptest.register.model.RegistrationModel
import com.soumen.mvptest.register.model.RegistrationResultModel
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
        if(userId.equals("") || password.equals("") || passwordAgain.equals("") ||
                email.equals("") || phone == 0L) {
            iRegisterView.onRegistrationCompleted(RegistrationResultModel(false, AppCommonValues.REG_ALL_FIELDS_REQUIRED))
        } else {
            iUserregistrationModel = RegistrationModel(userId, password, passwordAgain, email, phone)
            iRegisterView.onRegistrationCompleted(iUserregistrationModel.registerTheUser())
        }
    }
}