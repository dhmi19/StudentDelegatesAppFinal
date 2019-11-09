package com.example.dhruvmittal.studentdelegatesapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class UserDetails {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("UserName")
    @Expose
    private String UserName;
    @SerializedName("Password")
    @Expose
    private String Password;
    @SerializedName("Admin")
    @Expose
    private String Admin;
    @SerializedName("YearGroup")
    @Expose
    private String YearGroup;
    @SerializedName("DateOfCreation")
    @Expose
    private String DateOfCreation;
    @SerializedName("access_token")
    @Expose
    private String access_token;

    private String accessToken;

    private int userId;

    private String status;
    private String statusCode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String admin) {
        Admin = admin;
    }

    public String getYearGroup() {
        return YearGroup;
    }

    public void setYearGroup(String yearGroup) {
        YearGroup = yearGroup;
    }

    public String getDateOfCreation() {
        return DateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        DateOfCreation = dateOfCreation;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
