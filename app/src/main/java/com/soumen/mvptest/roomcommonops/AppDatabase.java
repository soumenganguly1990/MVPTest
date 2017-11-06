package com.soumen.mvptest.roomcommonops;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.soumen.mvptest.login.logindbops.LoginDao;
import com.soumen.mvptest.register.entity.UserEntity;
import com.soumen.mvptest.register.registrationdbops.RegistrationDao;

/**
 * Created by IN-LT-51 on 06-11-2017.
 */

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public abstract RegistrationDao registrationDao();
    public abstract LoginDao loginDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}