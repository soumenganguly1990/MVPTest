package com.soumen.mvptest.roomcommonops.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by IN-LT-51 on 06-11-2017.
 */
@Entity(tableName = "user")
class UserEntity {

    @PrimaryKey(autoGenerate = false)
    private lateinit var userId: String

    @ColumnInfo(name = "password")
    private lateinit var password: String

    @ColumnInfo(name = "email")
    private lateinit var email: String

    @ColumnInfo(name = "phone")
    private var phone: Long = 0

    public fun getUserId(): String {
        return userId
    }

    public fun setUserId(userId: String) {
        this.userId = userId
    }

    public fun getPassword(): String {
        return password
    }

    public fun setPassword(password: String) {
        this.password = password
    }

    public fun getEmail(): String {
        return email
    }

    public fun setEmail(email: String) {
        this.email = email
    }

    public fun getPhone(): Long {
        return phone!!
    }

    public fun setPhone(phone: Long) {
        this.phone = phone
    }
}