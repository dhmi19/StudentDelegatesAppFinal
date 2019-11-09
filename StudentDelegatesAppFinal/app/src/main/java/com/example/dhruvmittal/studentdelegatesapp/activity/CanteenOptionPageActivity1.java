package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.databinding.CanteenOptionPageActivity1Binding;

public class CanteenOptionPageActivity1 extends AppCompatActivity {

    private Button menu, logOut, nextPage;
    private char Q1, Q2;
    private boolean Q3;
    private CheckBox q1a, q1b, q1c, q1d;
    private CheckBox q2a, q2b, q2c, q2d;
    private CheckBox q3a, q3b;

    private CanteenOptionPageActivity1Binding activity1Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canteen_option_page_activity_1);

        activity1Binding = DataBindingUtil.setContentView(this, R.layout.canteen_option_page_activity_1);
        activity1Binding.setActivity(this);

        menu = findViewById(R.id.CanteenMenuButton1);
        logOut = findViewById(R.id.CanteenLogOutButton1);
        nextPage = findViewById(R.id.CanteenNextPageButton);

        q1a = findViewById(R.id.CanteenAnswer1A);
        q1b = findViewById(R.id.CanteenAnswer1B);
        q1c = findViewById(R.id.CanteenAnswer1C);
        q1d = findViewById(R.id.CanteenAnswer1D);

        q2a = findViewById(R.id.CanteenAnswer2A);
        q2b = findViewById(R.id.CanteenAnswer2B);
        q2c = findViewById(R.id.CanteenAnswer2C);
        q2d = findViewById(R.id.CanteenAnswer2D);


        q3a = findViewById(R.id.CanteenAnswer3A);
        q3b = findViewById(R.id.CanteenAnswer3B);

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
                //When opening the next page, all the data from the current page must be passed into the next page so the data is not lost
                //Here I have taken the user inputs and then passed them to the next page in a "bundle" below:

                Q1 = getAnswer1();
                Q2 = getAnswer2();
                Q3 = getAnswer3();

                Intent openNextCanteenPage = new Intent(CanteenOptionPageActivity1.this, CanteenOptionPageActivity2.class);
                Bundle canteenOptionPage1DataBundle = new Bundle();
                canteenOptionPage1DataBundle.putChar("q1", Q1);
                canteenOptionPage1DataBundle.putChar("q2", Q2);
                canteenOptionPage1DataBundle.putBoolean("q3", Q3);

                openNextCanteenPage.putExtras(canteenOptionPage1DataBundle);
                startActivity(openNextCanteenPage);

            }
        });
    }

    public void onCheckboxQ1Checked(){
        q1a.setEnabled(false);
        q1b.setEnabled(false);
        q1c.setEnabled(false);
        q1d.setEnabled(false);
    }

    public void onCheckboxQ2Checked(){
        q2a.setEnabled(false);
        q2b.setEnabled(false);
        q2c.setEnabled(false);
        q2d.setEnabled(false);
    }

    public void onCheckboxQ3Checked(){
        q3a.setEnabled(false);
        q3b.setEnabled(false);
    }

    private char getAnswer1(){
        char answer = 'f'; //f is a default value corresponding to error

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
        char answer = 'f'; //f is a default value corresponding to error

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
        boolean answer = false; //f is a default value corresponding to error

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

    private void openMenu(){
        Intent openMenuPage = new Intent(this, MenuActivity.class);
        startActivity(openMenuPage);
    }

    private void openLogInPage(){
        Intent openLogInPage = new Intent(this, LogInActivity.class);
        startActivity(openLogInPage);
    }
}
