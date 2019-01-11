package com.demo.livedatawithwebservice.ui;

import com.demo.livedatawithwebservice.R;
import com.demo.livedatawithwebservice.UserDataShowAdapter;
import com.demo.livedatawithwebservice.UserListViewModel;
import com.demo.livedatawithwebservice.remote.UserListResponse;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private UserListViewModel userListViewModel;
    private RecyclerView rvShowUserData;
    private UserDataShowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvShowUserData=findViewById(R.id.rvUserData);
        userListViewModel=ViewModelProviders.of(this).get(UserListViewModel.class);
        userListViewModel.getUserData();

        adapter = new UserDataShowAdapter(this, userListViewModel);
        rvShowUserData.setAdapter(adapter);
        rvShowUserData.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        rvShowUserData.setLayoutManager(new LinearLayoutManager(this));
        userListViewModel.getAllUser().observe(this, new Observer<List<UserListResponse.Data>>() {
            @Override
            public void onChanged(@Nullable List<UserListResponse.Data> data) {
                adapter.setUsers(data);


            }
        });
    }
}
