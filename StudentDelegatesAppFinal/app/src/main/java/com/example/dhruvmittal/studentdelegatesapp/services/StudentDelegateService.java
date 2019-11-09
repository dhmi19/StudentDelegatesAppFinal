package com.example.dhruvmittal.studentdelegatesapp.services;

import com.example.dhruvmittal.studentdelegatesapp.model.Categories;
import com.example.dhruvmittal.studentdelegatesapp.model.Feedback;
import com.example.dhruvmittal.studentdelegatesapp.model.FeedbackHistory;
import com.example.dhruvmittal.studentdelegatesapp.model.NewAccount;
import com.example.dhruvmittal.studentdelegatesapp.model.Response;
import com.example.dhruvmittal.studentdelegatesapp.model.User;
import com.example.dhruvmittal.studentdelegatesapp.model.UserDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;


public interface StudentDelegateService {

    @POST("public/index.php")
    Call<UserDetails> login(@Query("tag") String tag, @Body User user);

    @POST("public/index.php")
    Call<Response> saveFeedback(@Query("tag") String tag, @Body Feedback feedback);

    @POST("public/index.php")
    Call<FeedbackHistory[]> getHistory(@Query("tag") String tag, @Body UserDetails userDetails);

    @POST("public/index.php")
    Call<Response> signUp(@Query("tag") String tag, @Body NewAccount newAccount);

    @POST("public/index.php")
    Call<UserDetails> getPassword(@Query("tag") String tag, @Body User user);

    @POST("public/index.php")
    Call<Response> updateAccount(@Query("tag") String tag, @Body int UserID, String UserName, String Password, String YearGroup);

    @POST("public/index.php")
    Call<FeedbackHistory[]> getReportDetails(@Query("tag") String tag, @Body Categories categories);

    @POST("public/index.php")
    Call<FeedbackHistory[]> getDownloadReportDetails(@Query("tag") String tag, @Body Categories categories);
}



