package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.adapters.HistoryAdapter;
import com.example.dhruvmittal.studentdelegatesapp.model.Feedback;
import com.example.dhruvmittal.studentdelegatesapp.model.FeedbackHistory;
import com.example.dhruvmittal.studentdelegatesapp.model.UserDetails;
import com.example.dhruvmittal.studentdelegatesapp.services.StudentDelegateService;
import com.example.dhruvmittal.studentdelegatesapp.util.Constants;
import com.example.dhruvmittal.studentdelegatesapp.util.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewHistoryActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    String userId = null;
    String token;
    RecyclerView historyRecyclerView;
    HistoryAdapter adapter;
    FeedbackHistory[] feedbacks;
    ArrayList<FeedbackHistory> feedbackHistoryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_history_activity);

        sharedPreferences = getSharedPreferences("StudentDelegate", MODE_PRIVATE);
        historyRecyclerView = findViewById(R.id.feedBackHistoryRecyclerView);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(ViewHistoryActivity.this);
        historyRecyclerView.setLayoutManager(manager);

        userId = sharedPreferences.getString("UserId", null);
        token = sharedPreferences.getString("AccessToken",null);
        getUserHistory(userId,token);

    }

    public void getUserHistory(String userId,String token){

        //Retrofit + service connect with API on webhost
        Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
        StudentDelegateService service = retrofit.create(StudentDelegateService.class);
        String tag = "gethistory"; //Tag to ensure gethistory functions are called in the API

        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(Integer.parseInt(userId));
        userDetails.setAccessToken(token); //AccessToken is required to ensure user confidentiality


        service.getHistory(tag,userDetails).enqueue(new Callback<FeedbackHistory[]>() {

            //Response from the API comes in the format of an array of feedback Class objects
            @Override
            public void onResponse(@NonNull Call<FeedbackHistory[]> call, @NonNull Response<FeedbackHistory[]> response) {

                 //Gets response and stores in array of objects
                feedbacks = response.body();
                if(response.code() == 200 && feedbacks.length >0){

                    ArrayList<FeedbackHistory> feedbackHistoryArrayList = new ArrayList<>();

                    for(FeedbackHistory history : feedbacks){ //Adds objects to the arrayList
                        feedbackHistoryArrayList.add(history);
                    }

                    adapter = new HistoryAdapter(ViewHistoryActivity.this, feedbackHistoryArrayList); //Passes query details to HistoryAdapter class
                    historyRecyclerView.setAdapter(adapter); //Displays the history adapter
                }
            }

            @Override
            public void onFailure(@NonNull Call<FeedbackHistory[]> call, @NonNull Throwable t) {
                Log.d("Failure","Failure");
            }
        });


    }
}