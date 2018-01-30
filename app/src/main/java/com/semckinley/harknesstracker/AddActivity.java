package com.semckinley.harknesstracker;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.semckinley.harknesstracker.data.StudentContract;
import com.semckinley.harknesstracker.data.StudentDbHelper;

import java.util.ArrayList;

/**
 * Created by stephen.mckinley on 1/26/18.
 */

public class AddActivity extends AppCompatActivity {

    private EditText mStudentName;
    private Button mAddButton;
    private Button mSubmitButton;
    private Button mClearButton;
    private SQLiteDatabase mDb;



    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addclass_info);

        //create the student database helper and the db on first run
        StudentDbHelper dbHelper = new StudentDbHelper(this);

        //get a writeable database as we will be adding students...this may change as inputing data from a file and creating readable databases instead
        mDb = dbHelper.getWritableDatabase();
        //create the cursor to read from the database
        Cursor cursor; //more is needed here but not sure how it fits with my code yet

        mStudentName = (EditText) findViewById(R.id.et_student_name);

        mAddButton = (Button) findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    if(mStudentName != null){
                    ContentValues cv = new ContentValues();
                    cv.put(StudentContract.StudentEntry.COLUMN_STUDENT_NAME,  mStudentName.getText().toString());
                    cv.put(StudentContract.StudentEntry.COLUMN_COUNT, 0);
                   mDb.insert(StudentContract.StudentEntry.TABLE_NAME, null, cv);


                    mStudentName.setText("");}
                    else{mStudentName.setText("No name Entered");}
                }});

            mSubmitButton = (Button) findViewById(R.id.submit_button);
           mSubmitButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AddActivity.this, MainActivity.class);

                    startActivity(intent);}

        });
           mClearButton = (Button) findViewById(R.id.clear_button);
           mClearButton.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v){


                   mDb.delete(StudentContract.StudentEntry.TABLE_NAME, null, null);
               }
           });

    }


}
