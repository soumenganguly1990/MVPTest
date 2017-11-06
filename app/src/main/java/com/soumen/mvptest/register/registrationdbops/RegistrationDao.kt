package com.soumen.mvptest.register.registrationdbops

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.soumen.mvptest.register.entity.UserEntity

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
@Dao
interface RegistrationDao {

    @Insert
    fun createNewUser(user: UserEntity)
}