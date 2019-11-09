package com.example.dhruvmittal.studentdelegatesapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


public class NewAccount extends BaseObservable {

    private String username;
    private String password;
    private int admin;
    private String yearGroup;

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
    @Bindable
    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
    @Bindable
    public String getYearGroup() {
        return yearGroup;
    }

    public void setYearGroup(String yearGroup) {
        this.yearGroup = yearGroup;
    }
}
