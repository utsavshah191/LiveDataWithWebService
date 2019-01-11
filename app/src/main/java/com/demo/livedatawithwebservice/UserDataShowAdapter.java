package com.demo.livedatawithwebservice;

import com.demo.livedatawithwebservice.remote.UserListResponse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserDataShowAdapter extends RecyclerView.Adapter<UserDataShowAdapter
    .UserDataViewHolder> {

    private Context context;

    private List<UserListResponse.Data> lstuserdata;

    private UserListViewModel userViewModel;

    public UserDataShowAdapter(Context context, UserListViewModel userViewModel) {
        this.context = context;
        this.userViewModel = userViewModel;
    }

    @Override
    public UserDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
            .from(context).inflate(R.layout.list_item_row, parent, false);
        return new UserDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserDataViewHolder holder, int position) {
        if (lstuserdata != null) {
            final UserListResponse.Data user = lstuserdata.get(position);
            holder.txtName.setText(user.getFirstName());
            holder.txtId.setText(user.getId());

        } else {
            // Covers the case of data not being ready yet.

        }
    }

    public void setUsers(List<UserListResponse.Data> users) {
        lstuserdata = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (lstuserdata != null) {
            return lstuserdata.size();
        } else {

            return 0;
        }
    }

    static class UserDataViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtId;

        UserDataViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtId = itemView.findViewById(R.id.txtId);

        }
    }
}
