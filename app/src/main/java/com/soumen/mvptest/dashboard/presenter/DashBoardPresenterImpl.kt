package com.soumen.mvptest.dashboard.presenter

import com.soumen.mvptest.dashboard.model.AllUserModel
import com.soumen.mvptest.dashboard.model.IAllUserModel
import com.soumen.mvptest.dashboard.view.IDashboardView
import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
class DashBoardPresenterImpl : IDashBoardPresentation {

    var iDashboardView: IDashboardView
    lateinit var iAllUserModel: IAllUserModel

    constructor(iDashboardView: IDashboardView) {
        this.iDashboardView = iDashboardView
        iAllUserModel = AllUserModel()
    }

    override fun retrieveUserListFromRoomDb() {
        iDashboardView.onAllUserListRetrieved(iAllUserModel.retrieveFullListOfUsersFromDb())
    }

    override fun deleteUserFromRoomDb(user: UserEntity) {
        iDashboardView.onSelectedUserDeleted(iAllUserModel.deleteTheUserSelectedByUserFromDb(user))
    }
}