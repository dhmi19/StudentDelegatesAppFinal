package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dhruvmittal.studentdelegatesapp.R;

public class StudyPeriodOptionPageActivity1 extends AppCompatActivity {

    private Button menu, logOut, nextPage;
    private char Q1, Q2;
    private boolean Q3;
    private CheckBox q1a, q1b, q1c, q1d;
    private CheckBox q2a, q2b, q2c, q2d;
    private CheckBox q3a, q3b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_period_option_page_activity_1);

        menu = findViewById(R.id.StudyPeriodMenuButton1);
        logOut = findViewById(R.id.StudyPeriodLogOutButton1);
        nextPage = findViewById(R.id.StudyPeriodNextPageButton);

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

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Q1 = getAnswer1();
                Q2 = getAnswer2();
                Q3 = getAnswer3();

                Intent openNextStudyPeriodPage = new Intent(StudyPeriodOptionPageActivity1.this, StudyPeriodOptionPageActivity2.class);
                Bundle StudyPeriodOptionPage1DataBundle = new Bundle();
                StudyPeriodOptionPage1DataBundle.putChar("q1", Q1);
                StudyPeriodOptionPage1DataBundle.putChar("q2", Q2);
                StudyPeriodOptionPage1DataBundle.putBoolean("q3", Q3);

                openNextStudyPeriodPage.putExtras(StudyPeriodOptionPage1DataBundle);
                startActivity(openNextStudyPeriodPage);

                //openNextCanteenPage();
            }
        });

        q1a = findViewById(R.id.StudyPeriodAnswer1A);
        q1b = findViewById(R.id.StudyPeriodAnswer1B);
        q1c = findViewById(R.id.StudyPeriodAnswer1C);
        q1d = findViewById(R.id.StudyPeriodAnswer1D);

        q2a = findViewById(R.id.StudyPeriodAnswer2A);
        q2b = findViewById(R.id.StudyPeriodAnswer2B);
        q2c = findViewById(R.id.StudyPeriodAnswer2C);
        q2d = findViewById(R.id.StudyPeriodAnswer2D);


        q3a = findViewById(R.id.StudyPeriodAnswer3A);
        q3b = findViewById(R.id.StudyPeriodAnswer3B);
        
    }

    private void openMenu(){
        Intent openMenuPage = new Intent(this, MenuActivity.class);
        startActivity(openMenuPage);
    }

    private void openLogInPage(){
        Intent openLogInPage = new Intent(this, LogInActivity.class);
        startActivity(openLogInPage);
    }

    private void openNextStudyPeriodPage(){
        Intent openNextStudyPeriodPage = new Intent(this, StudyPeriodOptionPageActivity2.class);
        startActivity(openNextStudyPeriodPage);
    }


    private char getAnswer1(){
        char answer = 'f'; //f is a default value corresponging to error

        if(q1a.isChecked() && !q1b.isChecked()&& !q1c.isChecked()&& !q1d.isChecked()){
            System.out.println("Q1A selected");
            answer = 'a';
        } else if(!q1a.isChecked() && q1b.isChecked()&& !q1c.isChecked()&& !q1d.isChecked()){
            System.out.println("Q1B Selected");
            answer = 'b';
        } else if(!q1a.isChecked() && !q1b.isChecked()&& q1c.isChecked()&& !q1d.isChecked()){
            System.out.println("Q1C Selected");
            answer = 'c';
        }
        else if(!q1a.isChecked() && !q1b.isChecked()&& !q1c.isChecked()&& q1d.isChecked()){
            System.out.println("Q1D Selected");
            answer = 'd';
        } else{
            System.out.println("Please check only 1 box.");
        }
        return answer;
    }

    private char getAnswer2(){
        char answer = 'f'; //f is a default value corresponging to error

        if(q2a.isChecked() && !q2b.isChecked()&& !q2c.isChecked()&& !q2d.isChecked()){
            System.out.println("Q2A selected");
            answer = 'a';
        } else if(!q2a.isChecked() && q2b.isChecked()&& !q2c.isChecked()&& !q2d.isChecked()){
            System.out.println("Q2B Selected");
            answer = 'b';
        } else if(!q2a.isChecked() && !q2b.isChecked()&& q2c.isChecked()&& !q2d.isChecked()){
            System.out.println("Q2C Selected");
            answer = 'c';
        }
        else if(!q2a.isChecked() && !q2b.isChecked()&& !q2c.isChecked()&& q2d.isChecked()){
            System.out.println("Q2D Selected");
            answer = 'd';
        } else{
            System.out.println("Please check only 2 box.");
        }
        return answer;
    }

    private boolean getAnswer3(){
        boolean answer = false;

        if(q3a.isChecked() && !q3b.isChecked()){
            System.out.println("Q3A selected");
            answer = true;
        } else if(!q3a.isChecked() && q3b.isChecked()){
            System.out.println("Q3B Selected");
            answer = false;
        } else{
            System.out.println("Please check only 3 box.");
        }
        return answer;
    }
}

