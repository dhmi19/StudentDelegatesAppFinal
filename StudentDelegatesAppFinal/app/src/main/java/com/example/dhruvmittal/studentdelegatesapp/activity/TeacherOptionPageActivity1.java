package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.dhruvmittal.studentdelegatesapp.R;

public class TeacherOptionPageActivity1 extends AppCompatActivity {

    private Button menu, logOut, nextPage;
    private String Q1;
    private char Q2;
    private boolean Q3;
    private Spinner subjectSpinnerTeachersPage;
    private CheckBox q1a, q1b, q1c, q1d;
    private CheckBox q2a, q2b, q2c, q2d;
    private CheckBox q3a, q3b;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teachers_option_page_activity_1);

        menu = findViewById(R.id.TeachersMenuButton1);
        logOut = findViewById(R.id.TeachersLogOutButton1);
        nextPage = findViewById(R.id.TeachersNextPageButton);
        subjectSpinnerTeachersPage = findViewById(R.id.SubjectSpinnerTeachersPage);

        q2a = findViewById(R.id.TeachersAnswer2A);
        q2b = findViewById(R.id.TeachersAnswer2B);
        q2c = findViewById(R.id.TeachersAnswer2C);
        q2d = findViewById(R.id.TeachersAnswer2D);


        q3a = findViewById(R.id.TeachersAnswer3A);
        q3b = findViewById(R.id.TeachersAnswer3B);
        
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

                Intent openNextTeachersPage = new Intent(TeacherOptionPageActivity1.this, TeacherOptionPageActivity2.class);
                Bundle TeachersOptionPage1DataBundle = new Bundle();
                TeachersOptionPage1DataBundle.putString("q1", Q1);
                TeachersOptionPage1DataBundle.putChar("q2", Q2);
                TeachersOptionPage1DataBundle.putBoolean("q3", Q3);

                openNextTeachersPage.putExtras(TeachersOptionPage1DataBundle);
                startActivity(openNextTeachersPage);

            }
        });

        String[] items = new String[]{"Mathematics", "Biology", "Physics", "Chemistry", "Geography", "History", "Physical Education (P.E)", "Business Studies", "Economics", "Art"
                , "DT", "ITGS", "Computer Science", "Theory of Knowledge", "CAS", "Chinese", "Spanish", "German", "French"
                , "Thai", "Other Language", "Drama", "Music", "ESS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        subjectSpinnerTeachersPage.setAdapter(adapter);
    }

    private void openMenu(){
        Intent openMenuPage = new Intent(this, MenuActivity.class);
        startActivity(openMenuPage);
    }

    private void openLogInPage(){
        Intent openLogInPage = new Intent(this, LogInActivity.class);
        startActivity(openLogInPage);
    }

    private String getAnswer1(){
        String answer = subjectSpinnerTeachersPage.getSelectedItem().toString();
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
        boolean answer = false; //f is a default value corresponging to error

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
