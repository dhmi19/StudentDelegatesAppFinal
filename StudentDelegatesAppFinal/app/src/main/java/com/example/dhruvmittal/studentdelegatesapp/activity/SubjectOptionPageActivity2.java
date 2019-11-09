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
import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.model.Response;
import com.example.dhruvmittal.studentdelegatesapp.services.StudentDelegateService;
import com.example.dhruvmittal.studentdelegatesapp.util.Constants;
import com.example.dhruvmittal.studentdelegatesapp.util.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class SubjectOptionPageActivity2 extends AppCompatActivity {

    private Button menu, logOut, submit;
    private String Q1;
    private int Q2;
    private String Q3;
    private String Q4, Q5, Q6;
    private EditText Q4EditText,Q5EditText,Q6EditText;

    SharedPreferences sharedPreferences;
    int userId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_option_page_activity_2);

        sharedPreferences = getSharedPreferences("StudentDelegate", MODE_PRIVATE);
        userId = Integer.parseInt(sharedPreferences.getString("UserId",null));

        menu = findViewById(R.id.SubjectMenuButton2);
        logOut = findViewById(R.id.SubjectLogOutButton2);
        submit = findViewById(R.id.SubjectSubmitButton);
        
        Q4EditText = findViewById(R.id.SubjectQuestion4EditText);
        Q5EditText = findViewById(R.id.SubjectQuestion5EditText);
        Q6EditText = findViewById(R.id.SubjectOtherCommentsEditText);

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
                    Q1 = bundle.getString("q1", "Error in retrieving answer 1 in Subject Page 1 ");
                    Q2 = bundle.getInt("q2",0);
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

                addEntryToTblOption(userId, String.valueOf(Q1),Integer.toString(Q2),Q3,Q4,Q5,Q6);

                //System.out.println(Q1 +"    "+ Q2+"    "+ Q3+ "   "+ Q4 + "    "+ Q5+ "   "+ Q6);

                //Update userHistory after submitting
                //updateUserHistory();
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

    //Here, we must CREATE a new record with the UserName,
    private void addEntryToTblOption(int userId, String Q1, String Q2, String Q3, String Q4, String Q5, String Q6){
        String categoryType = "Subject";
        //System.out.print("UserId==="+userId+" Q1=="+Q1+" Q2="+Q2+" Q3="+Q3+" Q4="+Q4+" Q5="+Q5+" Q6="+Q6);
        String tag = "saveFeedBack";
        String accessToken = sharedPreferences.getString("AccessToken",null);
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

        Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
        StudentDelegateService service = retrofit.create(StudentDelegateService.class);

        service.saveFeedback(tag,feedback).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.code() == 200){
                    Toast.makeText(getApplicationContext(),"Feedback for subjects saved successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Something went wrong.Please try again",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("Error==","Error=="+t.getMessage());
                Toast.makeText(getApplicationContext(),"Something went wrong.Please try again",Toast.LENGTH_LONG).show();
            }
        });

    }
}
