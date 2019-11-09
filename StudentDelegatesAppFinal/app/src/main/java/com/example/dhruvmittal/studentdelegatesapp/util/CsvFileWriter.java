package com.example.dhruvmittal.studentdelegatesapp.util;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.dhruvmittal.studentdelegatesapp.model.FeedbackHistory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class CsvFileWriter { //Helps create the CSV File

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Username,Question1,Question2,Question3,Question4,Question5,Question6"; //Headers for the excel file
    public static  Boolean isFileCreated = false;

    public static void writeCsvFile(String fileName, FeedbackHistory[] downloadData,Context context) {

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+fileName); //Creates a new file



        List<FeedbackHistory> downloadDataHistory = new ArrayList<>(); //Arraylist will hold the data locally
        for(FeedbackHistory history : downloadData){ //iterates through the feedbackHistory[] and copies elements to arraylist above
            downloadDataHistory.add(history);
        }


        FileWriter fileWriter = null;
        try {
            Boolean isDeleted = false;
            if(!file.exists() || file.exists()){ //Checks if the file already exists
                if(file.exists()){
                    isDeleted = file.delete(); //Deletes any files with the same name if it already exists
                }

                if(isDeleted || !isDeleted){
                    Boolean isCreated = file.createNewFile(); // Creates a new file
                    if(isCreated){
                        fileWriter = new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath()+fileName,true);

                        fileWriter.append(FILE_HEADER.toString());

                        fileWriter.append(NEW_LINE_SEPARATOR);
                        for (FeedbackHistory downloadDatas : downloadDataHistory) {
                            //Writes the data into the file one at a time
                            fileWriter.append(String.valueOf(downloadDatas.getUserName()));
                            fileWriter.append(COMMA_DELIMITER);
                            fileWriter.append(downloadDatas.getQuestion1());
                            fileWriter.append(COMMA_DELIMITER);
                            fileWriter.append(downloadDatas.getQuestion2());
                            fileWriter.append(COMMA_DELIMITER);
                            fileWriter.append(downloadDatas.getQuestion3());
                            fileWriter.append(COMMA_DELIMITER);
                            fileWriter.append(downloadDatas.getQuestion4());
                            fileWriter.append(COMMA_DELIMITER);
                            fileWriter.append(downloadDatas.getQuestion5());
                            fileWriter.append(COMMA_DELIMITER);
                            fileWriter.append(downloadDatas.getQuestion6());
                            fileWriter.append(NEW_LINE_SEPARATOR);
                        }
                        System.out.println("CSV file was created successfully !!!");

                        isFileCreated = true;

                        //Closes the file properly
                        fileWriter.flush();
                        fileWriter.close();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter != null){
                    fileWriter.flush();
                    fileWriter.close();
                }

            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }


    }
}
