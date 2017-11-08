package com.soumen.mvptest.dashboard.presenter

import com.soumen.mvptest.dashboard.model.AllUserModel
import com.soumen.mvptest.dashboard.model.IAllUserModel
import com.soumen.mvptest.dashboard.view.IAllUsersView
import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
class AllUserPresenterImpl : IAllUserPresenter {

    var iAllUsersView: IAllUsersView
    lateinit var iAllUserModel: IAllUserModel

    constructor(iAllUsersView: IAllUsersView) {
        this.iAllUsersView = iAllUsersView
        iAllUserModel = AllUserModel()
    }

    override fun retrieveUserListFromRoomDb() {
        iAllUsersView.onAllUserListRetrieved(iAllUserModel.retrieveFullListOfUsersFromDb())
    }

    override fun deleteUserFromRoomDb(user: UserEntity) {
        iAllUsersView.onSelectedUserDeleted(iAllUserModel.deleteTheUserSelectedByUserFromDb(user))
    }
}