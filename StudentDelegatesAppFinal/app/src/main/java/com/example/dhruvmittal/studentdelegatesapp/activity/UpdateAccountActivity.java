package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.model.Response;
import com.example.dhruvmittal.studentdelegatesapp.services.StudentDelegateService;
import com.example.dhruvmittal.studentdelegatesapp.util.Constants;
import com.example.dhruvmittal.studentdelegatesapp.util.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class UpdateAccountActivity extends AppCompatActivity {

    private Button updateAccountButton, menuButton, deleteAccountButtonn;

    private EditText newPasswordUpdateAccount;
    private EditText oldPasswordUpdateAccount;
    private EditText newUserName;
    private Spinner yearGroupSpinner;
    SharedPreferences sharedPreferences;

    int userId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_account_activity);

        newPasswordUpdateAccount = findViewById(R.id.new_passwordUpdateAccount);
        oldPasswordUpdateAccount = findViewById(R.id.old_passwordUpdateAccount);
        newUserName = findViewById(R.id.userNameUpdateAccount);

        updateAccountButton = findViewById(R.id.btnUpdateAccount);
        yearGroupSpinner = findViewById(R.id.UpdateAccountYearGroupSpinner);
        menuButton = findViewById(R.id.btnMainMenu);
        deleteAccountButtonn = findViewById(R.id.btnDeleteAccount);

        sharedPreferences = getSharedPreferences("StudentDelegate", MODE_PRIVATE);

        String[] items = new String[]{"Year 6", "Year 7", "Year 8", "Year 9", "Year 10", "Year 11", "Year 12", "Year 13"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        yearGroupSpinner.setAdapter(adapter);


        //On Click listeners
        updateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Get user inputs for future user
            String userName = newUserName.getText().toString();
            String oldPassword = oldPasswordUpdateAccount.getText().toString();
            String newPassword = newPasswordUpdateAccount.getText().toString();
            String yearGroup = yearGroupSpinner.getSelectedItem().toString();
            userId =  Integer.parseInt(sharedPreferences.getString("UserId",null));

            if(oldPassword.equalsIgnoreCase(newPassword)){
                //toast passwords can not be same;
            } else{
                doUpdate(userId, userName, newPassword, yearGroup);
                openLogInPage();
            }

            }
        });


        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenuPage();
            }
        });

        deleteAccountButtonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    private void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void openMenuPage(){
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    private void openLogInPage(){
        Intent openLogInPage = new Intent(this, LogInActivity.class);
        startActivity(openLogInPage);
    }

    private void doUpdate(int userID, String userName, String password, String yearGroup){

        String tag = "updateaccount";

        Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
        StudentDelegateService service = retrofit.create(StudentDelegateService.class);

        service.updateAccount(tag, userID, userName, password, yearGroup).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) { //Executes when API responds
                if(response.code() == 200){ //200 is the success code for my APIs
                    Toast.makeText(getApplicationContext(),"Account updated, please log back in",Toast.LENGTH_LONG).show();
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
