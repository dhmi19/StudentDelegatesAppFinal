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

public class SubjectOptionPageActivity1 extends AppCompatActivity {

    private Button menu, logOut, nextPage;
    private String Q1;
    private int Q2;
    private boolean Q3;
    private CheckBox q1a, q1b, q1c, q1d;
    private CheckBox q2a, q2b, q2c, q2d;
    private CheckBox q3a, q3b;
    private Spinner subjectSpinner, homeworkTimeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_option_page_activity_1);

        menu = findViewById(R.id.SubjectMenuButton1);
        logOut = findViewById(R.id.SubjectLogOutButton1);
        nextPage = findViewById(R.id.SubjectNextPageButton);

        q3a = findViewById(R.id.SubjectAnswer3A);
        q3b = findViewById(R.id.SubjectAnswer3B);

        subjectSpinner = findViewById(R.id.SubjectSpinner);
        homeworkTimeSpinner = findViewById(R.id.HomeworkTimeSpinner);

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

                Intent openNextSubjectPage = new Intent(SubjectOptionPageActivity1.this, SubjectOptionPageActivity2.class);
                Bundle SubjectOptionPage1DataBundle = new Bundle();
                SubjectOptionPage1DataBundle.putString("q1", Q1);
                SubjectOptionPage1DataBundle.putInt("q2", Q2);
                SubjectOptionPage1DataBundle.putBoolean("q3", Q3);

                openNextSubjectPage.putExtras(SubjectOptionPage1DataBundle);
                startActivity(openNextSubjectPage);

                //openNextSubjectPage();
            }
        });

        String[] items = new String[]{"Mathematics", "Biology", "Physics", "Chemistry", "Geography", "History", "Physical Education (P.E)", "Business Studies", "Economics", "Art"
                , "DT", "ITGS", "Computer Science", "Theory of Knowledge", "CAS", "Chinese", "Spanish", "German", "French"
                , "Thai", "Other Language", "Drama", "Music", "ESS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        subjectSpinner.setAdapter(adapter);

        String[] homeworkHours = new String[]{"0 Hours", "1 Hour", "2 Hours", "3 Hours", "4 Hours", "5 Hours", "6 Hours", "6+ Hours"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, homeworkHours);
        homeworkTimeSpinner.setAdapter(adapter1);

    }

    private void openMenu(){
        Intent openMenuPage = new Intent(this, MenuActivity.class);
        startActivity(openMenuPage);
    }

    private void openLogInPage(){
        Intent openLogInPage = new Intent(this, LogInActivity.class);
        startActivity(openLogInPage);
    }

/*
    private void openNextSubjectOptionPage(){
        Intent openNextSubjectOptionPage = new Intent(this, SubjectOptionPageActivity2.class);
        startActivity(openNextSubjectOptionPage);
    }
*/

    private String getAnswer1(){
        String answer = subjectSpinner.getSelectedItem().toString();
        return answer;
    }

    private int getAnswer2(){
        int answer;
        String text = homeworkTimeSpinner.getSelectedItem().toString();

        switch (text){
            case "0 Hours":
                answer = 0;
                break;
            case "1 Hour":
                answer = 1;
                break;
            case "2 Hours":
                answer = 2;
                break;
            case "3 Hours":
                answer = 3;
                break;
            case "4 Hours":
                answer = 4;
                break;
            case "5 Hours":
                answer = 5;
                break;
            case "6 Hours":
                answer = 6;
                break;
            default:
                answer = 7;
                break;
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
