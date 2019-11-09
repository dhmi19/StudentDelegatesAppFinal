package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dhruvmittal.studentdelegatesapp.R;

public class ECAOptionPageActivity1 extends AppCompatActivity {

    private Button menu, logOut, nextPage;
    private char Q1, Q2, Q3;
    private CheckBox q1a, q1b, q1c, q1d;
    private CheckBox q2a, q2b, q2c, q2d;
    private CheckBox q3a, q3b, q3c, q3d;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eca_option_page_activity_1);

        menu = findViewById(R.id.ECAMenuButton1);
        logOut = findViewById(R.id.ECALogOutButton1);
        nextPage = findViewById(R.id.ECANextPageButton);


        q1a = findViewById(R.id.ECAAnswer1A);
        q1b = findViewById(R.id.ECAAnswer1B);
        q1c = findViewById(R.id.ECAAnswer1C);
        q1d = findViewById(R.id.ECAAnswer1D);

        q2a = findViewById(R.id.ECAAnswer2A);
        q2b = findViewById(R.id.ECAAnswer2B);
        q2c = findViewById(R.id.ECAAnswer2C);
        q2d = findViewById(R.id.ECAAnswer2D);


        q3a = findViewById(R.id.ECAAnswer3A);
        q3b = findViewById(R.id.ECAAnswer3B);
        q3c = findViewById(R.id.ECAAnswer3C);
        q3d = findViewById(R.id.ECAAnswer3D);

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

                Intent openNextECAPage = new Intent(ECAOptionPageActivity1.this, ECAOptionPageActivity2.class);
                Bundle ECAOptionPage1DataBundle = new Bundle();
                ECAOptionPage1DataBundle.putChar("q1", Q1);
                ECAOptionPage1DataBundle.putChar("q2", Q2);
                ECAOptionPage1DataBundle.putChar("q3", Q3);

                openNextECAPage.putExtras(ECAOptionPage1DataBundle);
                startActivity(openNextECAPage);

                //openNextECAPage();
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
/*
    private void openNextECAPage(){
        Intent openNextECAPage = new Intent(this, ECAOptionPageActivity2.class);
        startActivity(openNextECAPage);
    }
*/

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
            System.out.println("Please check only 1 box.");
        }
        return answer;
    }

    private char getAnswer3(){
        char answer = 'f'; //f is a default value corresponging to error

        if(q3a.isChecked() && !q3b.isChecked()&& !q3c.isChecked()&& !q3d.isChecked()){
            System.out.println("Q3A selected");
            answer = 'a';
        } else if(!q3a.isChecked() && q3b.isChecked()&& !q3c.isChecked()&& !q3d.isChecked()){
            System.out.println("Q3B Selected");
            answer = 'b';
        } else if(!q3a.isChecked() && !q3b.isChecked()&& q3c.isChecked()&& !q3d.isChecked()){
            System.out.println("Q3C Selected");
            answer = 'c';
        }
        else if(!q3a.isChecked() && !q3b.isChecked()&& !q3c.isChecked()&& q3d.isChecked()){
            System.out.println("Q3D Selected");
            answer = 'd';
        } else{
            System.out.println("Please check only 1 box.");
        }
        return answer;
    }    

}
