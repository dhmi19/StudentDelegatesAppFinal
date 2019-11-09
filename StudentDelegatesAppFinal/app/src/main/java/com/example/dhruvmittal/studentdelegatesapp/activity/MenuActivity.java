package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dhruvmittal.studentdelegatesapp.databinding.MenuActivitityBinding;
import com.example.dhruvmittal.studentdelegatesapp.R;

public class MenuActivity extends AppCompatActivity {

    private MenuActivitityBinding activityBinding;
    private TextView displayUserName;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activitity);

        sharedPreferences = getSharedPreferences("StudentDelegate", MODE_PRIVATE);

        displayUserName = findViewById(R.id.DisplayUsername);
        String userName = sharedPreferences.getString("UserName", null);
        displayUserName.setText("Username: "+ userName); //Displays the current username on the menu screen


        activityBinding = DataBindingUtil.setContentView(this, R.layout.menu_activitity);
        activityBinding.setActivity(this);


    }
    public void openCanteenPage(){
        Intent openCanteenOptionPage = new Intent(this, CanteenOptionPageActivity1.class);
        startActivity(openCanteenOptionPage);
    }

    public void openSubjectPage(){
        Intent openSubjectOptionPage = new Intent(this, SubjectOptionPageActivity1.class);
        startActivity(openSubjectOptionPage);
    }

    public void openECAPage(){
        Intent openECAOptionPage = new Intent(this, ECAOptionPageActivity1.class);
        startActivity(openECAOptionPage);
    }

    public void openFreePeriodPage(){
        Intent openFreePeriodPage = new Intent(this, StudyPeriodOptionPageActivity1.class);
        startActivity(openFreePeriodPage);
    }

    public void openTeacherPage(){
        Intent openTeachersPage = new Intent(this, TeacherOptionPageActivity1.class);
        startActivity(openTeachersPage);
    }

    public void openLogInPage(){
        Intent openLogInPage = new Intent(this, LogInActivity.class);
        startActivity(openLogInPage);
    }

    public void openReportPage(){
        Intent openReportPage = new Intent(this, ViewReportActivity.class);
        startActivity(openReportPage);
    }

    public void openHistoryPage(){
        Intent openHistoryPage = new Intent(this, ViewHistoryActivity.class);
        startActivity(openHistoryPage);
    }

    public void openUpdateAccountPage(){
        Intent openUpdateAccountPage = new Intent(this, UpdateAccountActivity.class);
        startActivity(openUpdateAccountPage);
    }
}

