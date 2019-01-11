package com.demo.livedatawithwebservice.dao;

import com.demo.livedatawithwebservice.remote.UserListResponse;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(UserListResponse.Data user);

    @Query("SELECT * FROM user_data Order By id ASC")
    LiveData<List<UserListResponse.Data>> getAllUser();
}
