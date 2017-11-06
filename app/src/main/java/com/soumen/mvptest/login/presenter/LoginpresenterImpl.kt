package com.soumen.mvptest.login.presenter

import com.soumen.mvptest.login.model.UserLoginModel
import com.soumen.mvptest.login.view.ILoginView

/**
 * Created by IN-LT-51 on 03-11-2017.
 */
class LoginpresenterImpl: ILoginPresenter {

    var iLoginView: ILoginView
    lateinit var userLoginModel: UserLoginModel

    constructor(iLoginView: ILoginView) {
        this.iLoginView = iLoginView
    }

    override fun resetLoginForm() {
        iLoginView.onResetLoginFields()
    }

    override fun loginFromDb(userId: String, password: String) {
        userLoginModel = UserLoginModel()
        iLoginView.onLoginResultRetrieved(userLoginModel.tryLoginFromDbWithUserData(userId, password))
    }
}