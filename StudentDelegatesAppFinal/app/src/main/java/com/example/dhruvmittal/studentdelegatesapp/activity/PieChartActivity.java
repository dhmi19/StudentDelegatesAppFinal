package com.example.dhruvmittal.studentdelegatesapp.activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dhruvmittal.studentdelegatesapp.BuildConfig;
import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.model.Categories;
import com.example.dhruvmittal.studentdelegatesapp.model.FeedbackHistory;
import com.example.dhruvmittal.studentdelegatesapp.services.StudentDelegateService;
import com.example.dhruvmittal.studentdelegatesapp.util.Constants;
import com.example.dhruvmittal.studentdelegatesapp.util.CsvFileWriter;
import com.example.dhruvmittal.studentdelegatesapp.util.RetrofitClient;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PieChartActivity extends AppCompatActivity {

    PieChart pieCharts;
    SharedPreferences sharedPreferences;
    String categoryType = null;
    FeedbackHistory feedbacks[];
    Integer q1Count = 0 ,q2Count = 0 ,q3Count = 0,q4Count = 0,q5Count = 0,q6Count = 0 ,size = 0;
    ArrayList<PieEntry> yvalues = new ArrayList<PieEntry>();
    Button exportCsvButton;

    private final int  REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        sharedPreferences = getSharedPreferences("StudentDelegate",MODE_PRIVATE);

        categoryType = sharedPreferences.getString("CategoyType",null);

        String username = sharedPreferences.getString("UserName",null);

        pieCharts = findViewById(R.id.piechart);
        exportCsvButton = findViewById(R.id.exportCsvButton);

        if(!username.equals("suko19")){
            exportCsvButton.setVisibility(View.GONE);
        }

        exportCsvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exportToCSV();
                //Toast.makeText(getApplicationContext(),"Excel file created, please open Excel", Toast.LENGTH_LONG).show();
                //System.out.println("i give up, i hardcoded this.... :(");
            }
        });

        Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
        StudentDelegateService service = retrofit.create(StudentDelegateService.class);
        String tag = "report";

        Categories categories = new Categories();
        categories.setCategoryType(categoryType);

        service.getReportDetails(tag,categories).enqueue(new Callback<FeedbackHistory[]>() {
            @Override
            public void onResponse(@NonNull Call<FeedbackHistory[]> call, @NonNull Response<FeedbackHistory[]> response) {

                feedbacks = response.body();
                if(response.code() == 200 && feedbacks.length > 0) {

                    size = feedbacks.length;
                    for (FeedbackHistory history : feedbacks) {

                        if (history.getQuestion1() != null && !history.getQuestion1().equals("")) {
                            q1Count += 1;
                        }

                        if (history.getQuestion2() != null && !history.getQuestion2().equals("")) {
                            q2Count += 1;
                        }

                        if (history.getQuestion3() != null && !history.getQuestion3().equals("")) {
                            q3Count += 1;
                        }

                        if (history.getQuestion4() != null && !history.getQuestion4().equals("")) {
                            q4Count += 1;
                        }

                        if (history.getQuestion5() != null && !history.getQuestion5().equals("")) {
                            q5Count += 1;
                        }

                        if (history.getQuestion6() != null && !history.getQuestion6().equals("")) {
                            q6Count += 1;
                        }
                    }

                    Integer totalCount = q1Count + q2Count + q3Count + q4Count + q5Count + q6Count;

                    Float Q1Count = (float) ((q1Count * 100) / totalCount);
                    Float Q2Count = (float) ((q2Count * 100) / totalCount);
                    Float Q3Count = (float) ((q3Count * 100) / totalCount);
                    Float Q4Count = (float) ((q4Count * 100) / totalCount);
                    Float Q5Count = (float) ((q5Count * 100) / totalCount);
                    Float Q6Count = (float) ((q6Count * 100) / totalCount);

                    Float totalPercentCount = Q1Count + Q2Count + Q3Count + Q4Count + Q5Count + Q6Count;
                    Float remainingCount;
                    Float greaterCount;
                    if(totalPercentCount == 100) {
                        System.out.print("Nothing to do");
                    } else if (totalPercentCount < 100) {
                        remainingCount = 100 - totalPercentCount;
                        Q3Count = Q3Count + remainingCount;
                    } else if (totalPercentCount > 100) {
                        greaterCount = totalPercentCount - 100;
                        Q3Count = Q3Count - greaterCount;
                    }

                    String values[] = new String[6];
                    values[0] = Q1Count + "f";
                    values[1] = Q2Count + "f";
                    values[2] = Q3Count + "f";
                    values[3] = Q4Count + "f";
                    values[4] = Q5Count + "f";
                    values[5] = Q6Count + "f";

                    ArrayList<String> description = new ArrayList<>();
                    description.add("Question1");
                    description.add("Question1");
                    description.add("Question3");
                    description.add("Question4");
                    description.add("Question5");
                    description.add("Question6");

                    for (int i = 0; i < values.length; i++) {
                        yvalues.add(new PieEntry(Float.parseFloat(values[i]), description.get(i)));
                    }

                    Log.d("Values", "Values===" + yvalues);
                    PieDataSet dataSet = new PieDataSet(yvalues, "Survey Results");

                    PieData data = new PieData(dataSet);
                    // In Percentage
                    data.setValueFormatter(new PercentFormatter());


                    // Default value
                    //data.setValueFormatter(new DefaultValueFormatter(0));
                    pieCharts.setData(data);
                    //pieCharts.setDescription("This is Pie Chart");
                    pieCharts.setDrawHoleEnabled(true);
                    pieCharts.setTransparentCircleRadius(58f);
                    pieCharts.setCenterText("Survey Details");
                    pieCharts.setHoleRadius(58f);
                    dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

                    data.setValueTextSize(13f);
                    data.setValueTextColor(Color.DKGRAY);

                    pieCharts.notifyDataSetChanged();
                    pieCharts.invalidate();

                }
            }

            @Override
            public void onFailure(@NonNull Call<FeedbackHistory[]> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void exportToCSV() {

        int writeExternalStoragePermission = ContextCompat.checkSelfPermission(PieChartActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(writeExternalStoragePermission!= PackageManager.PERMISSION_GRANTED)
        {
            // Request user to grant write external storage permission.
            ActivityCompat.requestPermissions(PieChartActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
        }else{
            createAndReadFile();
        }


    }

    private void createAndReadFile(){
        Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
        StudentDelegateService service = retrofit.create(StudentDelegateService.class);
        String tag = "downloadReport";
        Categories categories = new Categories();
        categories.setCategoryType(categoryType);

        service.getDownloadReportDetails(tag,categories).enqueue(new Callback<FeedbackHistory[]>() {
            @Override
            public void onResponse(@NonNull Call<FeedbackHistory[]> call, @NonNull Response<FeedbackHistory[]> response) {

                if(response.code() == 200){
                    FeedbackHistory []downloadData = response.body();
                    CsvFileWriter.writeCsvFile("/Surveys.csv",downloadData,getApplicationContext());

                    if(CsvFileWriter.isFileCreated){
                        Log.d("FilePath","FilePath==="+Environment.getExternalStorageDirectory().getAbsolutePath()+"/Survey.csv");
                        File files = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Surveys.csv");
                        //Uri uri = Uri.fromFile(files);
                        //Uri uri = FileProvider.getUriForFile(getBaseContext(),"com.mydomain.fileprovider", files);
                        Uri uri = FileProvider.getUriForFile(getBaseContext(),"com.example.dhruvmittal.studentdelegatesapp.util.GenericFileProvider", files);

                        Intent intent = new Intent();
                        //intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(uri);
                        try {
                            startActivityForResult(intent, 1);
                        }catch (Exception e){
                            System.out.println("Error in uri");
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<FeedbackHistory[]> call, @NonNull Throwable t) {
                Log.d("Error","Error");
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION)
        {
            int grantResultsLength = grantResults.length;
            if(grantResultsLength > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(getApplicationContext(), "You grant write external storage permission. Please click original button again to continue.", Toast.LENGTH_LONG).show();
                createAndReadFile();

            }else
            {
                Toast.makeText(getApplicationContext(), "You denied write external storage permission.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
