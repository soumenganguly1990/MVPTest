package com.soumen.mvptest.login.logindbops

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.soumen.mvptest.register.entity.UserEntity

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
@Dao
interface LoginDao {

    @Query("SELECT * FROM user where userId=:userId and password=:password")
    fun validateUserLogin(userId: String, password: String): UserEntity
}