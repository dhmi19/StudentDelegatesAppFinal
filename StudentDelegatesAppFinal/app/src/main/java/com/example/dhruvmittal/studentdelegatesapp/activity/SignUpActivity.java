package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.model.NewAccount;
import com.example.dhruvmittal.studentdelegatesapp.model.User;
import com.example.dhruvmittal.studentdelegatesapp.model.UserDetails;
import com.example.dhruvmittal.studentdelegatesapp.services.GMailSender;
import com.example.dhruvmittal.studentdelegatesapp.services.StudentDelegateService;
import com.example.dhruvmittal.studentdelegatesapp.util.Constants;
import com.example.dhruvmittal.studentdelegatesapp.util.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity {

    private Button createAccountButton, viewAllData, logInButton;
    private EditText userNamePassword;
    private EditText userNameSignUp;
    private EditText emailIDSignUp;
    private Spinner yearGroupSpinner;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        sharedPreferences = getSharedPreferences("StudentDelegate", MODE_PRIVATE);

        userNameSignUp = findViewById(R.id.userNameSignUp);
        userNamePassword = findViewById(R.id.passwordSignUp);
        createAccountButton = findViewById(R.id.btnCreateAccount);
        yearGroupSpinner = findViewById(R.id.SignUpYearGroupSpinner);
        logInButton = findViewById(R.id.btnLogIn);
        emailIDSignUp = findViewById(R.id.emailIDSignUP);

        String[] items = new String[]{"Year 6", "Year 7", "Year 8", "Year 9", "Year 10", "Year 11", "Year 12", "Year 13"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        yearGroupSpinner.setAdapter(adapter);


        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NewAccount newAccount = new NewAccount();

                //Get user inputs from the screen and store into newAccount object for future use
                newAccount.setUsername(userNameSignUp.getText().toString());
                newAccount.setPassword(userNamePassword.getText().toString());
                newAccount.setYearGroup(yearGroupSpinner.getSelectedItem().toString());
                newAccount.setAdmin(0);

                if(validateSignUp()) { //ensure that userName is of the correct format
                        doSignUp(newAccount); //if the userName is of a valid format, then sign up
                }

            }
        });

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
    }


    private void doSignUp(final NewAccount newAccount){

        //Retrofit facilitates the connection of app to API files
        Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
        StudentDelegateService service = retrofit.create(StudentDelegateService.class);
        String tag = "register"; //Used to determine the signUp process within the API

        service.signUp(tag,newAccount).enqueue(new Callback<com.example.dhruvmittal.studentdelegatesapp.model.Response>() {


            //Get response from the API and store it in the "Response" model class
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<com.example.dhruvmittal.studentdelegatesapp.model.Response> call, @NonNull Response<com.example.dhruvmittal.studentdelegatesapp.model.Response> response) {
                if(response.code() == 200){
                    Toast.makeText(getApplicationContext(),"User registered successfully",Toast.LENGTH_LONG).show();
                    sendEmail(newAccount);
                    Intent intent = new Intent(SignUpActivity.this, MenuActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"Something went wrong. Please check your credentials and try again",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<com.example.dhruvmittal.studentdelegatesapp.model.Response> call, @NonNull Throwable t) {
                Log.d("Failure====","Failure===="+t.getMessage());
                Toast.makeText(getApplicationContext(),"Something went wrong. Please check your credentials and try again",Toast.LENGTH_LONG).show();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void sendEmail(NewAccount newAccount){

        final String senderEmailID = "mitta52639@gmail.com";
        final String senderEmailPassword = "Dhruv2911";
        final String subject = "Your new Student Delegates Feedback App account";
        final String recieverEmailID = emailIDSignUp.getText().toString();
        String userName = newAccount.getUsername();
        String password = newAccount.getPassword();
        final String body = "Thank you for creating an account on the Student Delegates Feedback App"+ System.lineSeparator()+
                "Your log in details are sent below, please store these for future use:"
                + System.lineSeparator()+ System.lineSeparator()+
                "Username: "+ userName + System.lineSeparator()+ "Password: "+ password;


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender(senderEmailID,
                            senderEmailPassword);
                    sender.sendMail(subject, body, senderEmailID, recieverEmailID);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Email could not be sent successfully",Toast.LENGTH_LONG).show();
                }
            }

        }).start();

        Toast.makeText(getApplicationContext(),"Email sent successfully",Toast.LENGTH_LONG).show();
    }

    private boolean validateSignUp(){ //Checks if the entered username if of the correct format (Eg: abcd12)
        boolean isvalid = false;

        if (userNameSignUp.getText().toString().equalsIgnoreCase("")){
            userNameSignUp.setError("Please enter user name");
            userNameSignUp.requestFocus();
            isvalid = false;
        }else if (userNameSignUp.getText().toString().length() < 6){
            userNameSignUp.setError("Please Enter valid username that is 6 digits long");
            userNameSignUp.requestFocus();
            isvalid = false;
        }else {
            String user = userNameSignUp.getText().toString();
            String d = user.substring(user.length()-2,user.length()); // 12
            String c = user.substring(0,user.length()-2); // char

            try{
                Integer.parseInt(d);
                isvalid = true;

            }catch (NumberFormatException e){
                isvalid = false;
                userNameSignUp.setError("Please Enter valid username");
                userNameSignUp.requestFocus();
            }

            if (c.matches(".*\\d.*")){
                isvalid = false;
                userNameSignUp.setError("Please Enter valid username");

            }
        }

        if(userNamePassword.getText().toString().equalsIgnoreCase("")){
            userNamePassword.setError("Please enter a password");
            userNamePassword.requestFocus();
            isvalid = false;
        } else if(userNamePassword.getText().toString().length() > 15){
            userNamePassword.setError("Please ensure your password is less than 15 characters");
            userNamePassword.requestFocus();
            isvalid = false;
        }
        return isvalid;
    }

    private void openLoginPage(){
        Intent myIntent = new Intent(this, LogInActivity.class);
        startActivity(myIntent);
    }
}
