package com.example.dhruvmittal.studentdelegatesapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User extends BaseObservable {


    private String username;
    private String password;



    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
