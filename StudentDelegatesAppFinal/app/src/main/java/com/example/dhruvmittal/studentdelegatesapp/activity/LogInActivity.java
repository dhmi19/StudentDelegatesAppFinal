package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dhruvmittal.studentdelegatesapp.databinding.LogInActivityBinding;
import com.example.dhruvmittal.studentdelegatesapp.model.User;
import com.example.dhruvmittal.studentdelegatesapp.model.UserDetails;
import com.example.dhruvmittal.studentdelegatesapp.services.StudentDelegateService;
import com.example.dhruvmittal.studentdelegatesapp.util.Constants;
import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.util.RetrofitClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LogInActivity extends AppCompatActivity {

    private LogInActivityBinding activityBinding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_activity);

        sharedPreferences = getSharedPreferences("StudentDelegate", MODE_PRIVATE);

        //Activity binder saves lines of code by allowing direct access through XML files
        activityBinding = DataBindingUtil.setContentView(this, R.layout.log_in_activity);
        activityBinding.setUser(new User());
        activityBinding.setActivity(this);
    }

    public void onLoginButtonClick(User user){
        doLogin(user);
    }

    public void openSignUpPage(){
        Intent myIntent = new Intent(this, SignUpActivity.class);
        startActivity(myIntent);
    }


    public void doLogin(User user){

        //Retrofit + Service facilitates the interaction between the app and the database
        Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
        StudentDelegateService service = retrofit.create(StudentDelegateService.class);
        String tag = "login";
        service.login(tag,user).enqueue(new Callback<UserDetails>() {

            //Handles the response from the API
            @Override
            public void onResponse(@NonNull Call<UserDetails> call, @NonNull Response<UserDetails> response) {
                String userId = response.body().getId();

                if(userId != null ){

                    UserDetails userDetails = response.body();
                    //Stores the userdetails on the local storage of the device
                    sharedPreferences.edit().putString("UserId",userDetails.getId() != null ? userDetails.getId() : "0").apply();
                    sharedPreferences.edit().putString("AccessToken",userDetails.getAccess_token()).apply();
                    sharedPreferences.edit().putString("UserName",userDetails.getUserName()).apply();

                    //Start the menu activity from the log in page
                    Intent intent = new Intent(LogInActivity.this,MenuActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"Something went wrong. Please check your credentials and try again",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserDetails> call, @NonNull Throwable t) {
                Log.d("Failure====","Failure===="+t.getMessage());
                Toast.makeText(getApplicationContext(),"Something went wrong. Please check your credentials and try again",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
