package com.demo.livedatawithwebservice.roomdatabase;

import com.demo.livedatawithwebservice.dao.UserDao;
import com.demo.livedatawithwebservice.remote.UserListResponse;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {UserListResponse.Data.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDao userDeo();

    private static volatile UserRoomDatabase INSTANCE;

  public  static UserRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        UserRoomDatabase.class, "User_database")
                        .build();
                }
            }
        }
        return INSTANCE;
    }
}
