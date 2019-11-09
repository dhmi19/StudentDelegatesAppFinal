package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhruvmittal.studentdelegatesapp.model.Feedback;
import com.example.dhruvmittal.studentdelegatesapp.model.Response;
import com.example.dhruvmittal.studentdelegatesapp.services.StudentDelegateService;
import com.example.dhruvmittal.studentdelegatesapp.util.Constants;
import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.util.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class CanteenOptionPageActivity2 extends AppCompatActivity {

    private Button menu, logOut, submit;
    private char Q1, Q2;
    private String Q3;
    private String Q4, Q5, Q6;
    private EditText Q4EditText,Q5EditText,Q6EditText;

    SharedPreferences sharedPreferences;

    int userId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canteen_option_page_activity_2);

        sharedPreferences = getSharedPreferences("StudentDelegate", MODE_PRIVATE);

        userId = Integer.parseInt(sharedPreferences.getString("UserId",null));

        menu = findViewById(R.id.CanteenMenuButton2);
        logOut = findViewById(R.id.CanteenLogOutButton2);
        submit = findViewById(R.id.CanteenSubmitButton);
        Q4EditText = findViewById(R.id.CanteenQuestion4EditText);
        Q5EditText = findViewById(R.id.CanteenQuestion5EditText);
        Q6EditText = findViewById(R.id.CanteenOtherCommentsEditText);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogInPage();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() { //Get the required data and store in database from here.
            @Override
            public void onClick(View view) {

                //Get data from page 1:
                Intent intentExtras = getIntent();
                Bundle bundle = intentExtras.getExtras();

                if(bundle != null){
                    Q1 = bundle.getChar("q1", 'f');
                    Q2 = bundle.getChar("q2",'f');
                    if(String.valueOf(bundle.getBoolean("q3")).equals("true")){
                        Q3 = "true";
                    } else if (String.valueOf(bundle.getBoolean("q3")).equals("false")){
                        Q3 = "false";
                    } else{
                        Q3 = "error";
                        System.out.println("Error in getting Q3 from CanteenOptionPage1");
                    }
                }


                //Get data from the current page:
                Q4 = Q4EditText.getText().toString();
                Q5 = Q5EditText.getText().toString();
                Q6 = Q6EditText.getText().toString();

                //Add data to table in database
                addEntryToTblOption(userId, String.valueOf(Q1),String.valueOf(Q2),Q3,Q4,Q5,Q6);

            }
        });

    }

    private void openMenu(){
        Intent openMenuPage = new Intent(this, MenuActivity.class);
        startActivity(openMenuPage);
    }

    private void openLogInPage(){
        Intent openLogInPage = new Intent(this, LogInActivity.class);
        startActivity(openLogInPage);
    }

    private void addEntryToTblOption(int userId, String Q1, String Q2, String Q3, String Q4, String Q5, String Q6){

        String categoryType = "Canteen"; //This will store the category type in the table
        String tag = "saveFeedBack"; //This tag will determine which API function to call

        //Access token is used to verify if the user has authority to add feedback
        String accessToken = sharedPreferences.getString("AccessToken",null);

        //Creates an object from the model class "feedback"
        Feedback feedback = new Feedback();
        feedback.setAccessToken(accessToken);
        feedback.setUserId(userId);
        feedback.setQuestion1(Q1);
        feedback.setQuestion2(Q2);
        feedback.setQuestion3(Q3);
        feedback.setQuestion4(Q4);
        feedback.setQuestion5(Q5);
        feedback.setQuestion6(Q6);
        feedback.setCategoryType(categoryType);


        //Retrofit + service interface facilitate connection to API
        Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
        StudentDelegateService service = retrofit.create(StudentDelegateService.class);

        service.saveFeedback(tag,feedback).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) { //Executes when API responds
                if(response.code() == 200){ //200 is the success code for my APIs
                    Toast.makeText(getApplicationContext(),"Feedback for canteen saved successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Something went wrong.Please try again",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) { //Executes if something went wrong in the API
                Log.d("Error==","Error=="+t.getMessage());
                Toast.makeText(getApplicationContext(),"Something went wrong.Please try again",Toast.LENGTH_LONG).show();
            }
        });

    }
}
