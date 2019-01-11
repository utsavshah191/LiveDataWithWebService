package com.demo.livedatawithwebservice.repository;

import com.demo.livedatawithwebservice.MApplication;
import com.demo.livedatawithwebservice.dao.UserDao;
import com.demo.livedatawithwebservice.remote.ApiService;
import com.demo.livedatawithwebservice.remote.RetrofitInterface;
import com.demo.livedatawithwebservice.remote.UserListResponse;
import com.demo.livedatawithwebservice.roomdatabase.UserRoomDatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private UserDao userDao;

    private LiveData<List<UserListResponse.Data>> listLiveData;

    public UserRepository() {
        this.userDao = UserRoomDatabase.getDatabase(MApplication.context).userDeo();

        listLiveData = userDao.getAllUser();
    }

    public LiveData<List<UserListResponse.Data>> getListLiveData() {
        return listLiveData;
    }

    public void insert(UserListResponse.Data user) {
        new insertAsyncTask(userDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<UserListResponse.Data, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao userDeo) {
            mAsyncTaskDao = userDeo;
        }

        @Override
        protected Void doInBackground(UserListResponse.Data... users) {
            mAsyncTaskDao.insert(users[0]);
            return null;
        }
    }

    public void getUserData() {
        ApiService apiInterface =
            RetrofitInterface.getJsonClientWork().create(ApiService.class);
        apiInterface.getUserList().enqueue(new Callback<UserListResponse>() {
            private List<UserListResponse.Data> list;

            @Override
            public void onResponse(Call<UserListResponse> call,
                Response<UserListResponse> response) {
                list = response.body().getData();
                for (int i = 0; i < list.size(); i++) {
                    insert(list.get(i));

                }
            }

            @Override
            public void onFailure(Call<UserListResponse> call, Throwable t) {

            }
        });
    }
}
