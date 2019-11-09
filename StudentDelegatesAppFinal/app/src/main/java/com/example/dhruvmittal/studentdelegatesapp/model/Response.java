package com.example.dhruvmittal.studentdelegatesapp.model;


public class Response { //model class to get back response

    private String status;
    private String statusCode; //Checks to see if operation was success or not
    private String message; //If message is passed, it is stored here

    //Getters and Setters:
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
}


