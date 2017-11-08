package com.soumen.mvptest.dashboard.dashboarddbops

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Query
import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
@Dao
abstract class AllUserListDao {

    @Query("SELECT * FROM user")
    abstract fun getListOfAllUsers(): List<UserEntity>

    @Delete
    abstract fun deleteAnUser(user: UserEntity): Int
}