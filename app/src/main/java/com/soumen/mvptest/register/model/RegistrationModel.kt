package com.soumen.mvptest.register.model

import android.database.sqlite.SQLiteConstraintException
import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.register.entity.RegistrationResultModel
import com.soumen.mvptest.register.entity.UserEntity
import com.soumen.mvptest.roomcommonops.AppDatabase

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
class RegistrationModel: IUserRegistrationModel {

    var userId: String
    var password: String
    var passwordAgain: String
    var email: String

    constructor(userId: String, password: String, passwordAgain: String, email: String) {
        this.userId = userId
        this.password = password
        this.passwordAgain = passwordAgain
        this.email = email
    }

    private fun validateUserId(): Boolean {
        var reg: Regex = Regex(".*\\d+.*")
        return !userId.matches(reg)
    }

    private fun matchPasswords(): Boolean {
        return password.equals(passwordAgain)
    }

    private fun validatePassword(): Boolean {
        var reg: Regex = Regex("^[0-9]*$")
        return reg.matches(password)
    }

    private fun validateEmail(): Boolean {
        var reg: Regex = Regex("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")
        return reg.matches(email)
    }

    override fun registerTheUser(): RegistrationResultModel {
        if(validateUserId()) {
            if(matchPasswords()) {
                if(validatePassword()) {
                    if(validateEmail()) {
                        var u1: UserEntity = UserEntity()
                        u1.setUserId(userId)
                        u1.setPassword(password)
                        u1.setEmail(email)
                        try {
                            AppDatabase.getAppDatabase(AppCommonValues.context!!).registrationDao().createNewUser(u1)
                        } catch(s: SQLiteConstraintException) {
                            return RegistrationResultModel(false, AppCommonValues.REG_FAILED_CONSTRAINT)
                        } catch (e: Exception) {
                            return RegistrationResultModel(false, AppCommonValues.REG_FAILED)
                        }
                        return RegistrationResultModel(true, AppCommonValues.REG_SUCCESS)
                    } else {
                        return RegistrationResultModel(false, AppCommonValues.REG_INVALID_EMAIL)
                    }
                } else {
                    return RegistrationResultModel(false, AppCommonValues.REG_INVALID_PASSWORD)
                }
            } else {
                return RegistrationResultModel(false, AppCommonValues.REG_PASSWORDS_DIDNT_MATCH)
            }
        } else {
            return RegistrationResultModel(false, AppCommonValues.REG_INVALID_USER_ID)
        }
    }
}