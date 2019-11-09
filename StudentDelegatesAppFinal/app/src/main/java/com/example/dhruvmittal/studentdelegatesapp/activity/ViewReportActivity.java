package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.activity.LogInActivity;
import com.example.dhruvmittal.studentdelegatesapp.activity.MenuActivity;
import com.example.dhruvmittal.studentdelegatesapp.model.Categories;
import com.example.dhruvmittal.studentdelegatesapp.model.FeedbackHistory;
import com.example.dhruvmittal.studentdelegatesapp.services.StudentDelegateService;
import com.example.dhruvmittal.studentdelegatesapp.util.Constants;
import com.example.dhruvmittal.studentdelegatesapp.util.RetrofitClient;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewReportActivity extends AppCompatActivity {

    private Button logOutButton, menuButton , ViewReportCanteenButton ,ViewReportSubjectButton,ViewReportECAButton,ViewReportTeachersButton,ViewReportSudyPeriodButton;

    SharedPreferences sharedPreferences;
    FeedbackHistory feedbacks[];
    Integer q1Count = 0 ,q2Count = 0 ,q3Count = 0,q4Count = 0,q5Count = 0,q6Count = 0 ,size = 0;
    TextView usernameValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_report_activity);

        logOutButton = findViewById(R.id.ViewReportLogOutButton);
        menuButton = findViewById(R.id.ViewReportMenuButton);

        sharedPreferences = getSharedPreferences("StudentDelegate",MODE_PRIVATE);

        ViewReportCanteenButton = findViewById(R.id.ViewReportCanteenButton);
        ViewReportSubjectButton = findViewById(R.id.ViewReportSubjectButton);
        ViewReportECAButton = findViewById(R.id.ViewReportECAButton);
        ViewReportTeachersButton = findViewById(R.id.ViewReportTeachersButton);
        ViewReportSudyPeriodButton = findViewById(R.id.ViewReportSudyPeriodButton);
        usernameValueTextView = findViewById(R.id.usernameValueTextView);

        String username = sharedPreferences.getString("UserName",null);
        usernameValueTextView.setText(username);

        ViewReportCanteenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putString("CategoyType","Canteen").apply();
                Intent intent = new Intent(ViewReportActivity.this,PieChartActivity.class);
                startActivity(intent);
            }
        });

        ViewReportSubjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putString("CategoyType","Subject").apply();
                Intent intent = new Intent(ViewReportActivity.this,PieChartActivity.class);
                startActivity(intent);
            }
        });

        ViewReportECAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putString("CategoyType","ECA").apply();
                Intent intent = new Intent(ViewReportActivity.this,PieChartActivity.class);
                startActivity(intent);
            }
        });

        ViewReportTeachersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putString("CategoyType","Teacher").apply();
                Intent intent = new Intent(ViewReportActivity.this,PieChartActivity.class);
                startActivity(intent);
            }
        });

        ViewReportSudyPeriodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putString("CategoyType","StudyPeriod").apply();
                Intent intent = new Intent(ViewReportActivity.this,PieChartActivity.class);
                startActivity(intent);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogInPage();
            }
        });

    }

    private void openMenu() {
        Intent openMenuPage = new Intent(this, MenuActivity.class);
        startActivity(openMenuPage);
    }

    private void openLogInPage(){
        Intent openLogInPage = new Intent(this, LogInActivity.class);
        startActivity(openLogInPage);
    }

}
