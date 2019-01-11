package com.demo.livedatawithwebservice;

import com.demo.livedatawithwebservice.remote.UserListResponse;
import com.demo.livedatawithwebservice.repository.UserRepository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

public class UserListViewModel extends ViewModel {

    private UserRepository userRepository;

    private LiveData<List<UserListResponse.Data>> listLiveData;

    public UserListViewModel( ) {
        userRepository=new UserRepository();
        listLiveData=userRepository.getListLiveData();

    }

    public LiveData<List<UserListResponse.Data>> getAllUser() {
        return listLiveData;
    }

    public void insert(UserListResponse.Data user) {
        userRepository.insert(user);
    }
    public void getUserData(){
        userRepository.getUserData();
    }
}
