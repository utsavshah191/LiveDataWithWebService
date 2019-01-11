package com.demo.livedatawithwebservice.remote;

import com.google.gson.annotations.SerializedName;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

public class UserListResponse {

    /**
     * page : 2
     * per_page : 3
     * total : 12
     * total_pages : 4
     * data : [{"id":4,"first_name":"Eve","last_name":"Holt","avatar":"https://s3.amazonaws
     * .com/uifaces/faces/twitter/marcoramires/128.jpg"},{"id":5,"first_name":"Charles",
     * "last_name":"Morris","avatar":"https://s3.amazonaws
     * .com/uifaces/faces/twitter/stephenmoon/128.jpg"},{"id":6,"first_name":"Tracey",
     * "last_name":"Ramos","avatar":"https://s3.amazonaws
     * .com/uifaces/faces/twitter/bigmancho/128.jpg"}]
     */

    @SerializedName("page")
    private int page;

    @SerializedName("per_page")
    private int perPage;

    @SerializedName("total")
    private int total;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("data")
    private List<Data> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Entity(tableName = "user_data")
    public static class Data {

        /**
         * id : 4
         * first_name : Eve
         * last_name : Holt
         * avatar : https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg
         */
        @NonNull
        @PrimaryKey(autoGenerate = true)
        @SerializedName("id")
        private int id;

        @SerializedName("first_name")
        private String firstName;

        @SerializedName("last_name")
        private String lastName;

        @SerializedName("avatar")
        private String avatar;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
