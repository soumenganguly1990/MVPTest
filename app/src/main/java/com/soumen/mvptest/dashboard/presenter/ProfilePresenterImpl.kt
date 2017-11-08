package com.soumen.mvptest.dashboard.presenter

import com.soumen.mvptest.dashboard.model.IProfileModel
import com.soumen.mvptest.dashboard.model.ProfileModel
import com.soumen.mvptest.dashboard.view.IProfileView
import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 08-11-2017.
 */
class ProfilePresenterImpl: IProfilePresenter {

    lateinit var iProfileView: IProfileView
    lateinit var iProfileModel: IProfileModel

    constructor(iProfileView: IProfileView) {
        this.iProfileView = iProfileView
        iProfileModel = ProfileModel()
    }

    override fun updateUserInDb(user: UserEntity) {
        iProfileView.updateUserProfile(iProfileModel!!.updateProfile(user))
    }
}