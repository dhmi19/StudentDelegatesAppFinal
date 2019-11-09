package com.example.dhruvmittal.studentdelegatesapp.model;


public class FeedbackHistory {

    //Variables to hold values that need to be sent and received from the database
    private String CategoryType;
    private String Question1;
    private String Question2;
    private String Question3;
    private String Question4;
    private String Question5;
    private String Question6;
    private String DateCreated;
    private String UserId;
    private String SurveyID;
    private String id;
    private String UserName;

    //Getters and Setters
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getSurveyID() {
        return SurveyID;
    }

    public void setSurveyID(String surveyID) {
        SurveyID = surveyID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryType() {
        return CategoryType;
    }

    public void setCategoryType(String categoryType) {
        CategoryType = categoryType;
    }

    public String getQuestion1() {
        return Question1;
    }

    public void setQuestion1(String question1) {
        Question1 = question1;
    }

    public String getQuestion2() {
        return Question2;
    }

    public void setQuestion2(String question2) {
        Question2 = question2;
    }

    public String getQuestion3() {
        return Question3;
    }

    public void setQuestion3(String question3) {
        Question3 = question3;
    }

    public String getQuestion4() {
        return Question4;
    }

    public void setQuestion4(String question4) {
        Question4 = question4;
    }

    public String getQuestion5() {
        return Question5;
    }

    public void setQuestion5(String question5) {
        Question5 = question5;
    }

    public String getQuestion6() {
        return Question6;
    }

    public void setQuestion6(String question6) {
        Question6 = question6;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }
}
